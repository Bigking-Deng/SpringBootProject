package com.bigking.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bigking.springboot.bean.eunmBean.gender;
import lombok.Data;

@Data
@TableName(value = "testUser")
public class testUser {

    @TableId(value = "name")
    private String name;

    private Integer age;

    @TableField(value= "gender")
    private String gender;
}
