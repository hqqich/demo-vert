package me.hqqich.vertx.demo_vert

import io.vertx.core.Vertx


class ApplicationStart

fun main(args: Array<String>) {

  val vertx = Vertx.vertx()
  vertx.deployVerticle(MainVerticle::class.java.name)
}
