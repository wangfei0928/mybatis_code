package com.wf.mapper;

import com.wf.domain.Orders;
import com.wf.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderMapper {

    /*
        查询所有订单，同时查询所属订单的 用户信息
     */
    @Select("select * from orders")
    @Results( {  //代替resultMap标签
            @Result(property = "id" ,column = "id" ,id = true),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "total" ,column = "total"),
            @Result(property = "uid" ,column = "uid"),
            @Result(property = "user",javaType = User.class,column = "uid",one = @One(select = "com.wf.mapper.UserMapper.findById",fetchType = FetchType.EAGER))
    })
    public List<Orders> findALlWithUser();

    /*
    查询传播过来的用户id,查询用户所具有的订单信息
     */
    @Select("select * from orders where uid = #{uid}")
    public List<Orders> findOrderByUid(Integer uid);
}
