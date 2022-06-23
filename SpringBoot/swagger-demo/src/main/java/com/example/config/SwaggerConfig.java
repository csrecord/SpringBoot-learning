package com.example.config;

import com.example.controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


//SpringBootApplication里面有SpringBootConfiguration注解
//SpringBootConfiguration里有Configuration配置注解
//只要添加Configuration注解之后就会作为一个配置类,被Spring扫描到
@Configuration
@EnableSwagger2//开启Swagger
public class SwaggerConfig {
    //自定义自己的分组
    //配置需要显示的包信息
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    //配置了Swagger Docket的Bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //获取生产环境，通过environment.acceptsProfiles判断是否处于自己设定的环境中
        boolean b = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //配置分组
                .groupName("Hello")
                //是否启动swagger
                .enable(b)
                .select()
                //RequestHandlerSelectors:配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //.any()扫描全部
                //apis.(RequestHandlerSelectors.any())
                //扫描类上的注解
                //.apis(RequestHandlerSelectors.withClassAnnotation(GetMapping.class))
                //扫描方法上的注解
                //.apis(RequestHandlerSelectors.withMethodAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                //过滤什么路径
                //.paths(PathSelectors.ant("/example/**"))
                //.apis(RequestHandlerSelectors.withClassAnnotation(ResetC.class))
                .build();
    }

    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("陈恒飞", "https://baidu.com", "821132332@qq.com");

        return new ApiInfo(
                "Own's Swagger Diary",
                "Api Documentation",
                "1.0",
                "https://baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
