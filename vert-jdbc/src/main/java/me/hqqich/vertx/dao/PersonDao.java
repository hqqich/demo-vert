package me.hqqich.vertx.dao;

import java.util.List;
import me.hqqich.vertx.pojo.Person;

public interface PersonDao {
  Integer createTable();

  Integer dropTable();

  List<Person> selectAll();

  Person selectById(Integer id);

  Integer deleteById(Integer id);

  Integer update(Person person);

  Integer insert(Person person);

  List<Person> findAll();
}
