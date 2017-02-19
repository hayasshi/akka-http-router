package com.github.hayasshi.akkahttp_easyrouter

import akka.http.scaladsl.model.HttpMethod
import akka.http.scaladsl.server.Directives.{ method => methodDirective, _ }
import akka.http.scaladsl.server.{ PathMatcher, Route }

trait Routers {

  trait RouteDefine {
    type PathParam

    def method: HttpMethod
    def pathMatcher: PathMatcher[PathParam]
    def action: PathParam => Route

    lazy val route: Route = methodDirective(method)(path(pathMatcher).tapply(action))
  }

  def route[L](_method: HttpMethod, _pathMatcher: PathMatcher[L], _action: L => Route): RouteDefine = new RouteDefine {
    type PathParam = L

    val method: HttpMethod = _method
    val pathMatcher: PathMatcher[PathParam] = _pathMatcher
    val action: PathParam => Route = _action
  }

  case class Router(routeDefines: RouteDefine*) {
    val routes: Seq[Route] = routeDefines.map(_.route)
    val route: Route = routes.reduce(_ ~ _)
  }

}
