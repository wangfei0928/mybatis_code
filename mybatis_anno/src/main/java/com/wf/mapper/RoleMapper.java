package com.wf.mapper;

import com.wf.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
      /*
    查询传播过来的用户id,查询用户所具有的角色信息
     */
    @Select("SELECT *FROM sys_role  r INNER JOIN sys_user_role ur ON ur.roleid=r.id WHERE ur.userid = #{uid}")
    public List<Role> findAllById(Integer uid);
}
