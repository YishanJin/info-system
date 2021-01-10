package com.yishanjin.infosystem.config;

import com.yishanjin.infosystem.component.LoginHandlerInterceptor;
import com.yishanjin.infosystem.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//扩展SpringMVC
//@EnableWebMvc ---全面接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){//视图映射器
        registry.addViewController("/").setViewName("login");//thymeleaf会解析到templates/login.html thmeleaf默认文件后缀名为.html
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("main.html").setViewName("dashboard");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {//静态资源映射
        //registry.addResourceHandler("/**").addResourceLocations("classpath:/mystatic/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//注册拦截器
        //spring boot 已经做好了静态资源的映射，拦截器不会处理静态资源
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
