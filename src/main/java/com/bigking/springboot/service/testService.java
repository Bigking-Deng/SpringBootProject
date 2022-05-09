package com.bigking.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigking.springboot.bean.testUser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface testService extends IService<testUser> {

     void insertUser(testUser user);
     List<testUser> selectByName(String name);
}
