package com.demo.web_1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
    @RequestMapping("/")
    public String greet(){
        return "Welcome to Homepage..";
    }

    @RequestMapping("/about")
    public String About(){
        return "Welcome to Aboutpage..";
    }
}

//@Controller
//public class HomeController {
//
//    @RequestMapping("/")
//    @ResponseBody
//    public String greet(){
//        return "Welcome to Homepage..";
//    }
//}