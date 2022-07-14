package com.bigking.springboot;

import com.bigking.springboot.bean.testUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BIGApplication.class)
class ApplicationTests {

    @Qualifier("stringRedisTemplate_sj")
    private static StringRedisTemplate stringRedisTemplateSJ;

    @Test
    void contextLoads() {
        testUser t1 = new testUser();
        testUser t2 = new testUser();
        System.out.println(t1.getClass() + "  " + t2.getClass());
        System.out.println(t1.getClass() == t2.getClass());
        System.out.println(t1.getClass().equals(t2.getClass()));
    }

    @Test
    public void test1(){
        stringRedisTemplateSJ.opsForValue().set("1111111", "22");

        System.out.println(stringRedisTemplateSJ.opsForValue().get("1111111"));
    }


}
