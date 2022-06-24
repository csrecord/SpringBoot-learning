package com.example;

import com.example.pojo.User;
import com.example.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisApplicationTests {
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1(){
        redisUtil.set("name","kuangshen");
        System.out.println(redisUtil.get("name"));
    }

    @Test
    void contextLoads() {
        //操作redis数据类型
        //获取redis连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //connection.flushDb();
        //connection.flushAll();
        redisTemplate.opsForValue().set("mykey","chenhengfei");
        redisTemplate.opsForValue().get("mykey");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }
    @Test
    public void test() throws JsonProcessingException {
        //真实开发都用JSON传递对象
        User user = new User("chenhf", 3);
        //所有的对象都需要序列化
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
