package com.tiantian.sams.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

        registry.addViewController("/page-login.html").setViewName("page-login");
        registry.addViewController("/page-register.html").setViewName("page-register");
        registry.addViewController("/page-404.html").setViewName("page-404");
        registry.addViewController("/addRecord.html").setViewName("addRecord");
        registry.addViewController("/quireRecord.html").setViewName("quireRecord");
        registry.addViewController("/addVisitorStudent.html").setViewName("addVisitorStudent");
        registry.addViewController("/addVisitorDormitory.html").setViewName("addVisitorDormitory");
        registry.addViewController("/updateVisitorDormitoryEndTimeAndStatus.html").setViewName("updateVisitorDormitoryEndTimeAndStatus");
        registry.addViewController("/updateVisitorStudentEndTimeAndStatus.html").setViewName("updateVisitorStudentEndTimeAndStatus");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
