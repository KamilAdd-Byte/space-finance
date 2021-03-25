package com.spacefinance.spacefinance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String homePage(){
        return "index";
    }
    @GetMapping("/index")
    public String get(){
        return "index";
    }
}
