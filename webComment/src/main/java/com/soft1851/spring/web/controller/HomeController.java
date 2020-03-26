package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.LOL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
//@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "Hello Spring Mvc");
        LOL lol[] = {
                new LOL(0, "暗裔剑魔", "https://game.gtimg.cn/images/lol/universe/v1/assets/images/champion/splash/Aatrox_0.jpg"),
                new LOL(0, "九尾妖狐", "https://game.gtimg.cn/images/lol/universe/v1/assets/images/champion/splash/Ahri_0.jpg"),
                new LOL(0, "离群之刺", "https://game.gtimg.cn/images/lol/universe/v1/assets/images/champion/splash/Akali_0.jpg"),
        };
        List<LOL> lolList = Arrays.asList(lol);
        model.addAttribute("lolList", lolList);

        Map map = new HashMap();
        map.put("HTML", "网页的结构");
        map.put("CSS","网页的样式");
        map.put("JavaScript","网页的行为");
        model.addAttribute("map", map);
        return "home";
    }
}
