package com.wf.mp.simple.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wf.mp.simple.pojo.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    public List<User> findAll();
}
