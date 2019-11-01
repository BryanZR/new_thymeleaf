package com.nepu.spring.config;

import com.nepu.spring.component.MyLocalResolve;
import com.nepu.spring.component.loginHandlerInterceotor;
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
            //注册拦截器

            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射

                registry.addInterceptor( new loginHandlerInterceotor()).addPathPatterns("/**").
                        excludePathPatterns("/index.html","/","/user/login","/asserts/**","emp/add");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
               /* registry.addViewController("/dashboard").setViewName("dashboard");*/

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
