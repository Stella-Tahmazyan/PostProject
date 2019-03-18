package com.webPage.am.repository;

import com.webPage.am.entity.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutherRepository extends JpaRepository<Auther,Integer> {
}
