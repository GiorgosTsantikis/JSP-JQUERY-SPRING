package com.example.jspdemo.repository;

import com.example.jspdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BookRepository extends JpaRepository<Book,Integer> {
}
