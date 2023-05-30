package me.hqqich.vertx;

import io.vertx.core.Vertx;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import me.hqqich.vertx.config.JdbcConfig;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {


  @Test
  public void test01() {
    Vertx vertx = Vertx.vertx();
    JdbcConfig jdbcConfig = JdbcConfig.create(vertx);
    jdbcConfig.getJdbcClient().getConnection(res -> {
      SQLConnection connection = res.result();
      //if (res.succeeded()) {
        connection.query("select now()", e -> {
          ResultSet result = e.result();
          System.out.println(result.getRows());
        });
      //} else {

      //}
    });
  }

}
