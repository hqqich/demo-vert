package me.hqqich.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import me.hqqich.vertx.controller.DataBaseHandlerImpl;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() {

    // 创建一个路由
    Router router = Router.router(vertx);

    // 创建一个server
    HttpServer server = vertx.createHttpServer();

    router.route("/getDataBase").handler(new DataBaseHandlerImpl());

    server.requestHandler(router)
      .listen(8888)
      .onSuccess(new Handler<HttpServer>() {
        @Override
        public void handle(HttpServer httpServer) {
          System.out.println("启动成功" + server.actualPort());
        }
      });

    //vertx.createHttpServer()
    //    .requestHandler(req -> req.response().end("Hello Vert.x!"))
    //    .listen(8080);
  }

}
