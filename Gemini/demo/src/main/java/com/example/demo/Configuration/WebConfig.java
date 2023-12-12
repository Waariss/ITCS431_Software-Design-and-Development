package com.example.demo.Configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Map view controllers to specific URLs
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/astronomer").setViewName("astronomer");
        // Add more view controllers as needed
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Add static resources if needed
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
