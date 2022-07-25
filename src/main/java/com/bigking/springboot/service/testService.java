package com.bigking.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigking.springboot.bean.TestUser;

import java.util.List;


public interface testService extends IService<TestUser> {

     void insertUser(TestUser user);
     List<TestUser> selectByName(String name);
}
