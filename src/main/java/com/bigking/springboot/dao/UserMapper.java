package com.bigking.springboot.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigking.springboot.bean.testUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<testUser> {
    void insertUser(testUser user);
    List<testUser> selectByName(String name);
}
