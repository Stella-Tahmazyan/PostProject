package com.webPage.am.controller;

import com.webPage.am.repository.ArticleRepository;
import com.webPage.am.repository.CategoryRepository;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectPageController {



    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ArticleRepository articleRepository;
    @RequestMapping(value = {"/", "/page/login"})
    public String loginPage() {
        return "login";
    }

    @GetMapping("/page/register")
    public String registerPage() {
        return "register";
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

//    @GetMapping("/home")
//    public String home(ModelMap modelMap){
//        modelMap.addAttribute("category", repository.findAll());
//        modelMap.addAttribute("articles", articleRepository.findAll());
//        return "layout";
//    }
}
