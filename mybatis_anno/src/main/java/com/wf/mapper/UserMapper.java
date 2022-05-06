package com.wf.mapper;

import com.wf.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    /*
        查询用户
     */
    @Select(value = "select * from user")
    public List<User> findAll();

    /*
    添加用户
     */
    @Insert("insert into user(username, birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void save(User user);

    /*
    更新用户
     */
    @Update("update user set username=#{username},birthday = #{birthday} where id = #{id}")
    public void update(User user);

    /*
         删除用户
     */
    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);

    /*
        根据id查询用户
     */
    @Select("select * from user where id = #{uid}")
    public User findById(Integer id);

      /*
    查询所有用户及关联的所有信息
     */
    @Select("select * from user")
    @Results({
            @Result(property ="id",column ="id" , id = true),
            @Result(property ="username",column ="username" ),
            @Result(property ="birthday",column ="birthday"),
            @Result(property ="sex",column ="sex"),
            @Result(property ="address",column ="address"),
            @Result(property = "ordersList",javaType = List.class ,column = "id",many = @Many(select = "com.wf.mapper.OrderMapper.findOrderByUid"))
    })
    public List<User> findAllWithOrder();

    /*
        查询用户所关联的角色信息
     */
    @Select("select * from user")
    @Results({
            @Result(property ="id",column ="id" , id = true),
            @Result(property ="username",column ="username" ),
            @Result(property ="birthday",column ="birthday"),
            @Result(property ="sex",column ="sex"),
            @Result(property ="address",column ="address"),
            @Result(property = "roleList" ,javaType = List.class ,column = "id",many = @Many(select = "com.wf.mapper.RoleMapper.findAllById"))
    })
    public List<User> findAllWithRole();
}
