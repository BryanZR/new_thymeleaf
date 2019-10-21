package com.nepu.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class success {

    @ResponseBody
    @RequestMapping("hello")
    public String  hello(){
        return "你好！！！";
    }
    @RequestMapping("success")
    public  String success(){
        return "success";
    }

}
