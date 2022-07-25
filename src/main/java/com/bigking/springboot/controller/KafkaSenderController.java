package com.bigking.springboot.controller;

import com.bigking.springboot.bean.Dessert;
import com.bigking.springboot.bean.eunmBean.Category;
import com.bigking.springboot.bean.eunmBean.Status;
import com.bigking.springboot.utils.KafkaSenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping(value = "/kafkaSendMessage/")
public class KafkaSenderController {

    @Autowired
    KafkaSenderUtils kafkaSenderUtils;

    @GetMapping(value = "autosend_dessert")
    public  ResponseEntity sendDessertInfo(
            @RequestParam(value = "category", required = false, defaultValue = "BREAD") Category category,
            @RequestParam(value = "number", required = false, defaultValue = "10") Integer number

    ){
        for(int count = 0; count<number; count++){
            int price = (int)new Random().nextInt(20);
            String id = UUID.randomUUID().toString().replace("-","");
            Dessert dessert = new Dessert();
            dessert.setCategoryName(category);
            dessert.setId(id);
            dessert.setCreateTime(new Date());
            dessert.setPrice(price);
            dessert.setStatus(Status.PREPARE);
            kafkaSenderUtils.sendMessageAsync(id, dessert, "dessert");
        }
        return ResponseEntity.ok("sent successfully");

    }

}
