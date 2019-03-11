package com.webPage.am.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
