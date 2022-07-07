package com.chenhf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chenhf.mapper")
//MapperScan指定要扫描的Mapper类的包的路径
public class SeckillDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillDemoApplication.class, args);
    }

/**
 *
 * 接口测试：
 *          商品接口：/goods/toList
 *          windows QPS（50000次）优化前4012.2  优化后
 *          linux   QPS(10000次) 优化前395.6   优化后
 *
 *          秒杀接口：/seckill/doSeckill
 *          windows QPS(10000次) 优化前2283.6  优化后
 *
 */
}
