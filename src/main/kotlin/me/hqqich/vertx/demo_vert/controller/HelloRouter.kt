package me.hqqich.vertx.demo_vert.controller

import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router

class HelloRouter(
  httpMethod: HttpMethod,
  path: String,
  vertx: Vertx,
) {


  // 将这个传给 .requestHandler()
  val router: Router = Router.router(vertx)
  lateinit var route: Route

  init {
    router.route(httpMethod, path)

  }

  fun handle(): Route {
      return route.handler {
        it.response().end("hello word!!")
      }
  }



}
