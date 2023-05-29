package me.hqqich.vertx.demo_vert

import io.vertx.core.AbstractVerticle
import io.vertx.core.Handler
import io.vertx.core.Promise
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.StaticHandler
import io.vertx.ext.web.handler.TimeoutHandler
import me.hqqich.vertx.demo_vert.controller.ApiSignHandlerImpl
import me.hqqich.vertx.demo_vert.controller.HelloRouter

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {


//    val router = createRouter()

/*
    // Create a Router
    val router = Router.router(vertx)



    // Mount the handler for all incoming requests at every path and HTTP method
    router.route().handler { context ->
      // Get the address of the request
      val address = context.request().connection().remoteAddress().toString()
      // Get the query parameter "name"
      val queryParams = context.queryParams()
      val name = queryParams.get("name") ?: "unknown"
      // Write a json response
      context.json(
        json {
          obj (
            "name" to name,
            "address" to address,
            "message" to "Hello $name connected from $address"
          )
        }
      )
    }

*/

    val helloRouter = HelloRouter(httpMethod = HttpMethod.GET, path = "/hello", vertx)

    val router = Router.router(vertx)

    val server = vertx.createHttpServer()
    // 解析启
    router.route().handler(BodyHandler.create())
    // 超时时间
    router.route().handler(TimeoutHandler.create(5000));
    // html页面统一分配到template目录
    router.routeWithRegex(".*html").handler(StaticHandler.create("template"))
    // 静态资源统一分配到classpath下的static目录下
    router.route("/static/*").handler(StaticHandler.create("static"))
    // 后台接口统一到接口处理目录
    router.route("/api/*").handler(ApiSignHandlerImpl())

    server
      .requestHandler(router)
      .listen(8888)
      .onSuccess { server ->
        println("HTTP server started on port " + server.actualPort())
      }


    val port = config().getInteger("http.port", 8080)
//    vertx.createHttpServer()
//      .requestHandler { router.accept(it) }
//      .listen(port) { result ->
//        if (result.succeeded()) {
//          startFuture.complete()
//        } else {
//          startFuture?.fail(result.cause())
//        }
//      }

/*    vertx
      .createHttpServer()
      .requestHandler { req ->
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!")
      }
      .listen(port) { http ->
        if (http.succeeded()) {
          startPromise.complete()
          println("HTTP server started on port 8888")
        } else {
          startPromise.fail(http.cause());
        }
      }*/
  }

  override fun stop(stopPromise: Promise<Void>?) {
    super.stop(stopPromise)
  }


  //  override fun start(startFuture: Future<Void>?) {
//    val router = createRouter()
//    val port = config().getInteger("http.port", 8080)
//    vertx.createHttpServer()
//      .requestHandler { router.accept(it) }
//      .listen(port) { result ->
//        if (result.succeeded()) {
//          startFuture?.complete()
//        } else {
//          startFuture?.fail(result.cause())
//        }
//      }
//  }

  private fun createRouter() = Router.router(vertx).apply {
    get("/").handler(handlerRoot)
  }

  /**
   * create router instance
   */
  val handlerRoot = Handler<RoutingContext> { req ->
    req.response().end("Hello Kotlin Vertx Integration!")
  }


}
