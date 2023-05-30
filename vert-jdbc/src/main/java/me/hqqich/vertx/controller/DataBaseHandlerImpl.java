package me.hqqich.vertx.controller;

import com.google.gson.Gson;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import java.util.List;
import me.hqqich.vertx.dao.PersonDao;
import me.hqqich.vertx.dao.impl.PersonDaoImpl;
import me.hqqich.vertx.pojo.Person;

/**
 * Created by ChenHao on 2023/5/30 is 11:09.
 *
 * @author tsinglink
 */

public class DataBaseHandlerImpl implements DataBaseHandler {



  @Override
  public void handle(RoutingContext routingContext) {
    // 访问数据库
    PersonDao personDao = new PersonDaoImpl();
    //
    //// 建表
    //personDao.dropTable();
    //personDao.createTable();
    //
    //
    //// 插入数据
    //personDao.insert(new Person("曹操", 23));
    //personDao.insert(new Person("刘备", 24));
    //personDao.insert(new Person("孙权", 21));
    //
    //
    //// 删除
    //Integer deleteResult = personDao.deleteById(1);
    //System.out.println(deleteResult);
    //
    //
    //// 查询单个
    //Person person = personDao.selectById(2);
    //System.out.println(person);
    //
    //
    //// 更新
    //person.setAge(25);
    //Integer updateResult = personDao.update(person);
    //System.out.println(updateResult);
    //
    //
    // 查询所有
    List<Person> list = personDao.selectAll();
    for(Person p: list){
        System.out.println(p);
    }

    // 返回结果
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "application/json");
    response.end(new Gson().toJson(list));

  }

}
