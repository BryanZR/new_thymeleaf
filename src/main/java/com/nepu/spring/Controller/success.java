package com.nepu.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class success {

    @ResponseBody
    @RequestMapping("hello")
    public String  hello(){
        return "你好！！！";
    }
    @RequestMapping("success")
    public  String success(Map<String,Object> map) {
        map.put("hello", "<h1>我是你你爹</h1>");
        map.put("user", Arrays.asList("zhngsan","lisi","wangwyu"));
        return "success";

    }

}
