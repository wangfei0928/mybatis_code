package com.wf.test;

import com.wf.domain.Orders;
import com.wf.domain.User;
import com.wf.mapper.OrderMapper;
import com.wf.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {

    /*
      一对一关联查询，查询所有订单，与此同时还要查询每个订单所属的用户信息。
     */
    @Test
    public void test1() throws IOException {


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream );
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> orders = mapper.findAllWithUser();

        for (Orders order : orders) {
            System.out.println(order);
        }
        sqlSession.close();
    }
    /*
      一对多关联查询，查询所有用户，与此同时还要查询每个订单息。
     */
    @Test
    public void test2() throws IOException {


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream );
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

       List<User> allWithOrder = mapper.findAllWithOrder();

        for (User user: allWithOrder) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /*
     多对多关联查询，查询所有用户，与此同时还要查询每个成员信息。
    */
    @Test
    public void test3() throws IOException {


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream );
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allWithRole = mapper.findAllWithRole();

        for (User user: allWithRole) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    /*
     一对一嵌套查询，查询所有订单及关联的用户信息，与此同时还要查询每个成员信息。
    */
    @Test
    public void test4() throws IOException {


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream );
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> allWithUser2 = mapper.findAllWithUser2();

        for (Orders orders : allWithUser2) {
            System.out.println(orders);
        }
        sqlSession.close();
    }

    /*
     一对多嵌套查询，查询所有订单及关联的用户信息，与此同时还要查询每个成员信息。
    */
    @Test
    public void test5() throws IOException {


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream );
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allWithOrder2 = mapper.findAllWithOrder2();
        for (User user : allWithOrder2) {
            System.out.println(user);

//            System.out.println(user.getOrdersList());
        }
        sqlSession.close();
    }

    /*
    多对多嵌套查询，查询所有订单及关联的用户信息，与此同时还要查询每个角色信息。
   */
    @Test
    public void test6() throws IOException {


        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream );
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allWithRole2 = mapper.findAllWithRole2();
        for (User user : allWithRole2) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
