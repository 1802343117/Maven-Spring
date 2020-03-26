package com.soft1851.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "Hello Spring Mvc");
        return "home";
    }
}
