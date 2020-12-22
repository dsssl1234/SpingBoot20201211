package com.example.config;


import com.example.component.LoginHandlerInterceptor;
import com.example.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//使用WebMvcConfigurer可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //试图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
        //registry.addViewController("/").setViewName("login");
        //registry.addViewController("/index.html").setViewName("login");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
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
                        //这边如果直接排除/static,已经无法访问到静态文件，可以在static下在建一个文件夹，将这些包裹起来
                        .excludePathPatterns("/", "/index.html", "/user/login", "/css/**", "/img/**", "/js/**", "/webjars/**");
            }
        };
        return configurer;
    }

    //自定义了一个试图解析器,如果想自定义一些功能，只要写这个组件，然后交给springboot，会帮我们自动装配
    //这个是一个过滤去的试图
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
