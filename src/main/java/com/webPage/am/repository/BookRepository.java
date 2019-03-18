package com.webPage.am.repository;

import com.webPage.am.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
