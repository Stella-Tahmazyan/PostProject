package com.webPage.am.controller;

import com.webPage.am.entity.Category;
import com.webPage.am.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

 @GetMapping("/add/category")
    public String addCateg(){
     Category category = new Category();
     category.setCat("IT");
     repository.save(category);
        return "redirect:/";

 }
 @GetMapping("/get/category")
 public String getCategory(ModelMap modelMap){
     modelMap.addAttribute("category",repository.findAll());
     return "layout";
 }

}

