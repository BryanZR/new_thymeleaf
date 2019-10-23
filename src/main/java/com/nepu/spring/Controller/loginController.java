package com.nepu.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import sun.security.util.Password;

import java.util.Map;

@Controller
public class loginController {
    @PostMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map) {

if(!StringUtils.isEmpty(username)&&"123456".equals(password))
        return "dashboard";
else
    map.put("msg","用户名密码错误");
    return "login";

    }
}
