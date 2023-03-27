package com.bigking.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigking.springboot.bean.TestUser;
import com.bigking.springboot.dao.UserMapper;
import com.bigking.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl extends ServiceImpl<UserMapper, TestUser> implements TestService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(TestUser user) {
          userMapper.insertUser(user);
    }

    public List<TestUser> selectByName(String name){ return userMapper.selectByName(name);}
}
