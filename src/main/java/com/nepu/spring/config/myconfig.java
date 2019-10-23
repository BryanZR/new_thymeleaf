package com.nepu.spring.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public WebMvcConfigurerAdapter  webMvcConfigurerAdapter (){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
            }
        };
        return adapter;
    }

    @Configuration
    public class PathConfig extends WebMvcConfigurerAdapter {
//        重写addResourceHandlers（）后，\upload\ 下的静态资源可以访问了
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
            super.addResourceHandlers(registry);
        }
    }

}
