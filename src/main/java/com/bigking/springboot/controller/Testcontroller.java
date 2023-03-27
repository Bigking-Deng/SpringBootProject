package com.bigking.springboot.controller;

import com.bigking.springboot.bean.TestUser;
import com.bigking.springboot.service.TestService;
import com.bigking.springboot.utils.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value="/testStart/")
public class Testcontroller {

    @Autowired
    private TestService testService;

    @Resource(name = "lettuceRedisTemplate")
    public StringRedisTemplate stringRedisTemplate;


//    @Resource(name = "kafkaTemplate")
//    public KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaConsumer kafkaConsumer;

     @RequestMapping(value="hello")
     public String testStart(){
        return "Hello";
     }

     @RequestMapping(value="insertUser", method = RequestMethod.POST)
     public ResponseEntity<?> insertUser(@RequestBody TestUser user){
         try{
             testService.insertUser(user);
             return ResponseEntity.ok("success");
         }catch (Exception e){
             e.printStackTrace();
             return ResponseEntity.badRequest().body("failed: " + e.getMessage());
         }

     }

    @RequestMapping(value="searchUser", method = RequestMethod.GET)
    public ResponseEntity<?> searchUser(@RequestParam(value = "name", required = true) String name){

            if(name==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            List<TestUser> userList = testService.selectByName(name);
            return ResponseEntity.ok(userList);


    }

    @RequestMapping(value="redistest", method = RequestMethod.GET)
    public ResponseEntity<?> redistest(){

        stringRedisTemplate.opsForValue().set("1111111", "22");

        String message = stringRedisTemplate.opsForValue().get("1111111");

        return ResponseEntity.ok(message);


    }

    @RequestMapping(value="kafkatest", method = RequestMethod.GET)
    public ResponseEntity<?> kafkatest(){





        return ResponseEntity.ok("success");


    }


}
