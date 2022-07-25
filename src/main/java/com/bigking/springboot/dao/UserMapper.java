package com.bigking.springboot.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigking.springboot.bean.TestUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<TestUser> {
    void insertUser(TestUser user);
    List<TestUser> selectByName(String name);
}
