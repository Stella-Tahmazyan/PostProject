package com.webPage.am.controller;

import com.webPage.am.entity.Article;
import com.webPage.am.entity.Category;
import com.webPage.am.repository.ArticleRepository;
import com.webPage.am.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("add/article")
public String addArticle(){
    Article article =new Article();
    article.setArt("ddd");
    article.setDate(new Date());
    Category category= new Category();

    category.setId(1);
//    article.setCategory(category);
    repository.save(article);
    return "redirect:/get/category";
}

@GetMapping("/get/art")
public String getArt(@RequestParam("id") int id, ModelMap modelMap){
        modelMap.addAttribute("article",  repository.getOne(id));
    modelMap.addAttribute("category",categoryRepository.findAll());
    return "Article";

}
}
