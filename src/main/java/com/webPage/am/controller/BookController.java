package com.webPage.am.controller;

import com.webPage.am.entity.Article;
import com.webPage.am.entity.Book;
import com.webPage.am.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
  private BookRepository repository;

  @PostMapping("/add/book")
  public String addBook(@ModelAttribute Book book) {
    repository.save(book);
    return "redirect:/home";
  }
}
