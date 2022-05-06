package com.wf.test;

import com.wf.domain.Orders;
import com.wf.domain.User;
import com.wf.mapper.OrderMapper;
import com.wf.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    //在@Test方法标注的方法执行之前来调用
    @Before
    public  void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();

    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

/*
    测试查询方法
 */
    @Test
    public void testSelect() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all =  mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /*
    测试更新方法
     */
    @Test
    public  void  testInsert(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("狗猛");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("二龙山");

        mapper.save(user);
    }

    @Test
    public void  TestUpdate(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("柳岩真美");
        user.setAddress("211");
        user.setBirthday(new Date());
        user.setId(6);
        mapper.update(user);
    }

    @Test
    public void TestDelete(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        mapper.delete(9);
    }

/*
    一对一查询，注解方式
 */
    @Test
    public void  testOneToOne(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> aLlWithUser =  mapper.findALlWithUser();

        for (Orders orders : aLlWithUser) {
            System.out.println(orders);
        }
    }
    /*
    一对多查询，注解方式
 */
    @Test
    public void  testOneToMany(){
       UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> aLlWithOrder =  mapper.findAllWithOrder();

        for (User user : aLlWithOrder) {
            System.out.println(user);
            System.out.println(user.getOrdersList());
        }
    }

    /*
   多对多查询，注解方式
*/
    @Test
    public void  testManyToMany(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> aLlWithRole =  mapper.findAllWithRole();

        for (User user : aLlWithRole) {
            System.out.println(user);
            System.out.println(user.getRoleList());
        }
    }
}
