package com.batch.exsample.batch_demo2.controller;


import com.batch.exsample.batch_demo2.entity.BookEntity;
import com.batch.exsample.batch_demo2.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class Controller {

@Autowired
    private BookRepository bookRepository;

@GetMapping
    public List<BookEntity> getAll(){
    log.info("Getall is called");
return bookRepository.findAll();
}
}
