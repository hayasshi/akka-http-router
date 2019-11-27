# akka-http-router

```scala
import akkahttp_router._

import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.server.Directives._

val controller = new ControllerYouDefined(???)

val categoryId = LongNumber
val productId = LongNumber

val router = Router(
  route(GET,  "category", controller.getCategories),
  route(POST, "category", controller.postCategory),

  route(GET,  "category" / categoryId, controller.getCategory),

  route(GET,  "category" / categoryId / "products", controller.getProducts),
  route(POST, "category" / categoryId / "products", controller.postProduct),

  route(GET,  "category" / categoryId / "products" / productId, controller.getProduct)
)
val v1api = pathPrefix("v1")(router.route)

Http().bindAndHandle(v1api, "localhost", 8080)
```

## Motivation

The [akka-http](http://doc.akka.io/docs/akka-http/current/index.html) is a great tool kit for building to web service interface!

However, I do not want to deeply nest route definitions, like this:

```scala
val route = pathPrefix("v1") {
  path("category") {
    get {
      ???
    } ~
    post {
      ???
    }
  } ~
  path("category" / LongNumber) { cid =>
    get {
      ???
    } ~
    path("products") {
      get {
        ???
      } ~
      post {
        ???
      } ~
    } ~
    path("products" / LongNumber) { pid =>
      ???
    }
  }
}
```

And, `Directives` create more nested. :-(

I think this route definition is contained two problems.

- Bad visibility.
- To become fat `Route`.

This tool separates route definition and application logic like the [PlayFramework's router](https://www.playframework.com/documentation/2.5.x/ScalaRouting).

## Installation

```scala
resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies += "com.github.hayasshi" %% "akka-http-router" % "0.5.0-rt1"
```

## Usage

Define a function matching the number of URL path parameters.

```scala
val getCategories: Route = ???
val getProducts: Long => Route = ???
val getProduct: ((Long, Long)) => Route = ???
```

And defined.

```scala
import akkahttp_router._

import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.server.Directives._

val router = Router(
  route(GET, "category", getCategories),

  route(GET, "category" / LongNumber / "products", getProducts),

  route(GET, "category" / LongNumber / "products" / LongNumber, getProduct)
)
```
