package com.max.config;

import com.max.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ClientMvcConfig implements WebMvcConfigurer {

    /**
     * 不做处理的页面跳转
     * 目的走视图解析器
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("user_manage");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/menu_manage").setViewName("menu_manage");
        registry.addViewController("/menu_add").setViewName("menu_add");
        registry.addViewController("/user_manage").setViewName("user_manage");
        registry.addViewController("/user_add").setViewName("user_add");
        registry.addViewController("/order").setViewName("order");
        registry.addViewController("/order_handler").setViewName("order_handler");
    }


    /**
     * 自定义拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/images/**", "/js/**", "/layui/**"  // 过滤静态资源
                        , "/account/login", "/login");  // 过滤登录界面 和登录接口
    }

    /**
     * 设置静态资源的位置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);

    }


}
