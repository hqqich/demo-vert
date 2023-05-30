package me.hqqich.vertx.dao.impl;

import java.io.IOException;
import java.util.List;
import me.hqqich.vertx.dao.PersonDao;
import me.hqqich.vertx.pojo.Person;
import me.hqqich.vertx.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by Administrator on 2022/6/20 is 9:50.
 *
 * @Description
 * @Author hqqich <hqqich1314@outlook.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2022/6/20
 */

public class PersonDaoImpl implements PersonDao {

  public Integer createTable() {
    try (SqlSession session = MyBatisUtil.getSqlSession()) {
      PersonDao mapper = session.getMapper(PersonDao.class);
      Integer result = mapper.createTable();
      session.commit();
      return result;

    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public Integer dropTable() {
    try (SqlSession session = MyBatisUtil.getSqlSession()) {
      PersonDao mapper = session.getMapper(PersonDao.class);
      Integer result = mapper.dropTable();
      session.commit();
      return result;

    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public List<Person> selectAll() {
    List<Person> list = null;

    try (SqlSession session = MyBatisUtil.getSqlSession()) {
      // Person person = session.selectOne("com.mouday.dao.PersonDao.selectById", 1);
      // 等价于

      PersonDao mapper = session.getMapper(PersonDao.class);
      list = mapper.selectAll();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return list;
  }

  public Person selectById(Integer id) {
    Person person = null;

    try (SqlSession session = MyBatisUtil.getSqlSession()) {
      // Person person = session.selectOne("com.mouday.dao.PersonDao.selectById", 1);
      // 等价于

      PersonDao mapper = session.getMapper(PersonDao.class);
      person = mapper.selectById(id);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return person;
  }

  public Integer deleteById(Integer id) {
    try (SqlSession session = MyBatisUtil.getSqlSession()) {
      PersonDao mapper = session.getMapper(PersonDao.class);
      Integer result = mapper.deleteById(id);
      session.commit();
      return result;

    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public Integer insert(Person person) {
    try (SqlSession session = MyBatisUtil.getSqlSession()) {
      PersonDao mapper = session.getMapper(PersonDao.class);
      Integer result = mapper.insert(person);
      session.commit();
      return result;

    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  //这里也可以不用在实现的接口中写代码
  @Override
  public List<Person> findAll() {
    return null;
  }

  public Integer update(Person person) {
    try (SqlSession session = MyBatisUtil.getSqlSession()) {
      PersonDao mapper = session.getMapper(PersonDao.class);
      Integer result = mapper.update(person);
      session.commit();
      return result;

    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }
}
