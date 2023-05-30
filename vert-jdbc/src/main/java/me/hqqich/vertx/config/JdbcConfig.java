package me.hqqich.vertx.config;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;


public class JdbcConfig {
  private static JDBCClient jdbcClient;
  private static JsonObject config;
  private static JdbcConfig jdbcConfig;

  static {
    config = new JsonObject();
    config.put("url", "jdbc:mysql://172.25.88.254:3306/mydb?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=GMT%2B8&useAffectedRows=true");
    config.put("driver_class", "com.mysql.cj.jdbc.Driver");
    config.put("user", "root");
    config.put("password", "root");
  }

  public static JdbcConfig create(Vertx vertx){
    if (jdbcClient == null){
      synchronized (JdbcConfig.class) {
        jdbcConfig = new JdbcConfig();
        jdbcConfig.init(vertx);
      }
    }
    return jdbcConfig;
  }

  private void init(Vertx vertx) {
    jdbcClient = JDBCClient.createShared(vertx, config);
  }

  public JDBCClient getJdbcClient(){
    return jdbcClient;
  }


}

