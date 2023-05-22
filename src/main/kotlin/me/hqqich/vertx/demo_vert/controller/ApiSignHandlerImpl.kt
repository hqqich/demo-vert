package me.hqqich.vertx.demo_vert.controller

import io.vertx.ext.web.RoutingContext

class ApiSignHandlerImpl: ApiSignHandler {


  override fun handle(context: RoutingContext) {

    // 验证签名是否正确
    val sign: String = context.request().getParam("sign")

    if ("123" == sign) {
      // 验证通过，放行
      context.next()
    } else {
      // 拦截
      context.end("签名验证失败")
    }
  }

}
