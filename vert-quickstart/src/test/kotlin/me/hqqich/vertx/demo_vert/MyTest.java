package me.hqqich.vertx.demo_vert;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.junit.jupiter.api.Test;



public class MyTest {


  @Test
  public void test01() {

    Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));

  }


}
