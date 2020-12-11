package com.example.config;


import com.example.component.LoginHandlerInterceptor;
import com.example.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer  {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
        //registry.addViewController("/").setViewName("login");
        //registry.addViewController("/index.html").setViewName("login");
    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                //配置这个是为了登录的时候重定向，防止出现重复请求登录的情况（F5的时候会出现）
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //excludePathPatterns除外的意思
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index.html","/login/user","/asserts/**","/webjars/**");
            }
        };
        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }


}
