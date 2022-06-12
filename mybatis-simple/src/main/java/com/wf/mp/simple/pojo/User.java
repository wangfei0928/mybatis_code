package com.wf.mp.simple.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @TableName("tb_user")
public class User {

        private Integer id;
        private String username;
        private String password;
        private String name;
        private Integer age;
        private String email;

    }
