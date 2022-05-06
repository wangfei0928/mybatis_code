package com.wf.mapper;

import com.wf.domain.Role;
import com.wf.domain.User;

import java.util.List;

public interface UserMapper {

/*
       一对多关联查询：查询所有用户，同时还要查询出每个用户关联的订单信息
 */

    public List<User> findAllWithOrder();

    /*
       多对多关联查询：查询所有用户，同时还要查询出每个用户关联的角色信息
 */
    public List<User> findAllWithRole();

    /*
       根据id查询用户
 */
    public User findByid(Integer id);

    /*
       一对多嵌套查询：查询所有用户，同时还要查询出每个用户关联的订单信息
 */

    public List<User> findAllWithOrder2();

    /*
       多对多嵌套查询：查询所有用户，同时还要查询出每个用户关联的角色信息
 */

    public List<User> findAllWithRole2();
}
