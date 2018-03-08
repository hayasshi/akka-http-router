package akkahttp_router

import akka.http.scaladsl.server.Route

trait Implicits {

  implicit def toUnitArgFunction1(r: Route): Unit => Route = _ => r

  implicit def toTuple1ArgFunction1[A](ar: A => Route): Tuple1[A] => Route = ar.compose(_._1)

}
