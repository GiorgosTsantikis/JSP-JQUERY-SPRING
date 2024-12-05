package com.example.jspdemo.service;

import com.example.jspdemo.exception.DuplicateBookException;
import com.example.jspdemo.model.Book;
import com.example.jspdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public BookService(){

    }

    public List<Book> getBooks(){

        //addBook(new Book("name","author","isbn"));

        return this.bookRepository.findAll();
    }

    public Book addBook(Book book) {
        if(getBooks().stream().anyMatch(x->x.getIsbn().equals(book.getIsbn()))){
            System.out.println("throwing");
            throw new DuplicateBookException(book);
        }
        System.out.println("\n\n\n add "+book+"\n"+getBooks()+"\n\n\n");
         return this.bookRepository.save(book);
    }
}
