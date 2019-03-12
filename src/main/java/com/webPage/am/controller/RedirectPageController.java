package com.webPage.am.controller;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectPageController {

    @RequestMapping(value={"/", "/page/login"})
    public String loginPage(){
        return "login";
    }

    @GetMapping("/page/register")
    public String registerPage(){
        return "register";
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
