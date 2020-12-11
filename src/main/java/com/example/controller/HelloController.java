package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(){
        return "hello world";
    }

    @RequestMapping("/success")
    public  String success(Map<String,Object>map){
        map.put("hello","你好");
        map.put("users", Arrays.asList("zhangsan","lisi"));
        return "success";
    }

}
