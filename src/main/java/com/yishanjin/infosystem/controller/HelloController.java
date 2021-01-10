package com.yishanjin.infosystem.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "login";
//    }

    //@ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "login";
    }


}