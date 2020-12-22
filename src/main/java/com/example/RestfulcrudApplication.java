package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication标注这个类是一个Springboot的引用
@SpringBootApplication
public class RestfulcrudApplication {

    public static void main(String[] args) {
        //启动
        SpringApplication.run(RestfulcrudApplication.class, args);
    }

}
