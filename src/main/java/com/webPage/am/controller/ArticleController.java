package com.webPage.am.controller;

import com.webPage.am.entity.Article;
import com.webPage.am.entity.Category;
import com.webPage.am.repository.ArticleRepository;
import com.webPage.am.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class ArticleController {

@Autowired
private ArticleRepository repository;
@Autowired
    private CategoryRepository  categoryRepository;

@GetMapping("/art/delete")
public String deleteArticle(@RequestParam("id") int id){
    Optional<Article> one = repository.findById(id);
    if (one.isPresent()) {
        repository.deleteById(id);
    }
    return "redirect:/get/category";

}

    @GetMapping("/edit/article")
    public String editArticle(@RequestParam("id") int id,ModelMap modelMap){
    modelMap.addAttribute("article",    repository.getOne(id));
    return "edit";
}
    @PostMapping("/save/article/edit")
    public String saveEdit(@ModelAttribute Article article){
        repository.save(article);
        return "redirect:/";
    }
    @PostMapping("/add/article")
     public String addArticle(@ModelAttribute Article article){
     repository.save(article);
    return "redirect:/";
}

@GetMapping("/get/art")
public String getArt(@RequestParam("id") int id, ModelMap modelMap){
         modelMap.addAttribute("article",  repository.getOne(id));
    modelMap.addAttribute("category",categoryRepository.findAll());

    return "Article";

}
}
