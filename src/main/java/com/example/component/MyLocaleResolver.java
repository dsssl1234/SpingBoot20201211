package com.example.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        //如果没有就使用默认的国际化解析器
        Locale locale = Locale.getDefault();
        //如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(l)) {
            //zh_CN
            String[] ls = l.split("_");
            //国家 地区
            locale = new Locale(ls[0], ls[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
