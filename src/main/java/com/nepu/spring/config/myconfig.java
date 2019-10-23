package com.nepu.spring.config;

import com.nepu.spring.component.MyLocalResolve;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc
@Configuration
public class myconfig implements WebMvcConfigurer {
    /* @Override
     public void addViewControllers(ViewControllerRegistry registry) {
 registry.addViewController("/").setViewName("index");
     }*/
    //所有的webmvccof都会
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return adapter;
    }

    @Configuration
    public class PathConfig extends WebMvcConfigurerAdapter {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
            super.addResourceHandlers(registry);
        }
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolve();
    }
}
