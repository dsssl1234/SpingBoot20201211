package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam String username,@RequestParam String password, Map<String,String> map, HttpSession session){

        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",session);
            return "redirect:/main.html";
        }else {
            map.put("msg","登录失败");
            return "login";
        }
    }
}
