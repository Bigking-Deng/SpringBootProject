package com.bigking.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "TestUser")
public class TestUser {

    @TableId(value = "name")
    private String name;

    private Integer age;

    @TableField(value= "Gender")
    private String gender;
}
