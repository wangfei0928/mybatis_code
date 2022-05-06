package com.wf.mapper;

import com.wf.domain.Role;

import java.util.List;

public interface RoleMapper {
    /*
    根据用户id， 查询对应角色
     */
    public List<Role> findByUid(Integer uid);
}
