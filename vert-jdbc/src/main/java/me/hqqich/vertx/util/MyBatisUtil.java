package me.hqqich.vertx.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import me.hqqich.vertx.dao.PersonDao;
import me.hqqich.vertx.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

  private static SqlSessionFactory factory = null;

  // 使用static静态代码块，随着类的加载而加载，只执行一次
  static {
    try {
      String resource = "mybatis-config.xml";
      // 加载MyBatis的主配置文件
      InputStream inputStream = Resources.getResourceAsStream(resource);
      // 通过构建器（SqlSessionFactoryBuilder）构建一个SqlSessionFactory工厂对象
      factory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static SqlSession getSqlSession() throws IOException {
    return factory.openSession();
  }

  public static void main(String[] args) {
    List<Person> list = null;
    try (SqlSession session = MyBatisUtil.getSqlSession()) {

      PersonDao mapper = session.getMapper(PersonDao.class);
      list = mapper.findAll();

    } catch (IOException e) {
      e.printStackTrace();
    }
    list.forEach(System.out::println);
  }

}
