package com.webPage.am.controller;

import com.webPage.am.entity.Article;
import com.webPage.am.entity.Auther;
import com.webPage.am.entity.Book;
import com.webPage.am.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
  @Autowired
  private BookRepository repository;

  @PostMapping("/add/book")
  public String addBook(@ModelAttribute Book book) {

    Auther auther = new Auther();
    auther.setId(1);
    List<Auther> dd= new ArrayList<>();
    dd.add(auther);
    book.setAuthers(dd);


    // Add tag references in the post

    // Add post reference in the tags
    List<Book> books= new ArrayList<>();
    books.add(book);

    auther.setBooks(books);

    repository.save(book);
    return "redirect:/page";
  }

  @GetMapping("/book/delete")
  public String deleteArticle(@RequestParam("id") int id) {
    Optional<Book> one = repository.findById(id);
    if (one.isPresent()) {
      repository.deleteById(id);
    }
    return "redirect:/page";

  }
}
