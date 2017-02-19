package com.github.hayasshi.akkahttp_easyrouter

import akka.http.scaladsl.server.Route

trait Implicits {

  implicit def argToUnit(r: Route): Unit => Route = _ => r

  implicit def argToTuple1[A](ar: A => Route): Tuple1[A] => Route = ar.compose(_._1)

}
