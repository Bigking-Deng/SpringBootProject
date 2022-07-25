package com.bigking.springboot.bean;

import com.bigking.springboot.bean.eunmBean.Category;
import com.bigking.springboot.bean.eunmBean.Status;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Dessert implements Serializable {

    private String id;
    private Integer price;
    private Category categoryName;
    private Date createTime;
    private Status status;
}
