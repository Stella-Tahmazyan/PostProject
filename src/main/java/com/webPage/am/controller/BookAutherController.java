package com.webPage.am.controller;

import com.webPage.am.repository.AutherRepository;
import com.webPage.am.repository.BookRepository;
import com.webPage.am.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookAutherController {

    @Autowired
    private AutherRepository repository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/page")
    public String home(ModelMap modelMap){
        modelMap.addAttribute("books",bookRepository.findAll());
        modelMap.addAttribute("authers",repository.findAll());
        modelMap.addAttribute("category",categoryRepository.findAll());

        return "book";
    }
}
