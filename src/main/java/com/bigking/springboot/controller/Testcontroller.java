package com.bigking.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/testStart/")
public class Testcontroller {

    @RequestMapping(value="hello")
    public String testStart(){
        return "Hello";
     }

}
