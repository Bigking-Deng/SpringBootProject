package com.bigking.springboot;

import com.bigking.springboot.bean.testUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        testUser t1 = new testUser();
        testUser t2 = new testUser();
        System.out.println(t1.getClass() + "  " + t2.getClass());
        System.out.println(t1.getClass() == t2.getClass());
        System.out.println(t1.getClass().equals(t2.getClass()));
    }

}
