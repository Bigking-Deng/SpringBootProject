package com.bigking.springboot;

import com.bigking.springboot.bean.TestUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BIGApplication.class)
class ApplicationTests {

    @Qualifier("stringRedisTemplate_sj")
    private static StringRedisTemplate stringRedisTemplateSJ;

    @Test
    void contextLoads() {
//        TestUser t1 = new TestUser();
//        TestUser t2 = new TestUser();
//        System.out.println(t1.getClass() + "  " + t2.getClass());
//        System.out.println(t1.getClass() == t2.getClass());
//        System.out.println(t1.getClass().equals(t2.getClass()));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


    }

    @Test
    public void test1(){
        stringRedisTemplateSJ.opsForValue().set("1111111", "22");

        System.out.println(stringRedisTemplateSJ.opsForValue().get("1111111"));
    }


}
