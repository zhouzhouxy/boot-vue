package com.asura.vue.controller;

import com.asura.vue.domain.Book;
import com.asura.vue.domain.PageResult;
import com.asura.vue.domain.Result;
import com.asura.vue.dtos.BookDto;
import com.asura.vue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:35
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/query")
    public ResponseEntity<PageResult<Book>> queryBookByCondition(@RequestBody BookDto bookDto){
        System.out.println(bookDto);
        PageResult<Book> page = bookService.findPageByCondition(bookDto);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/up")
    public ResponseEntity<Result> upBook(@RequestBody Book book){
        Result result = bookService.upBook(book);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addBook(@RequestBody Book book){
        Result result = bookService.addBook(book);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Result> delBook(@PathVariable("id") Integer id){
        Result result = bookService.delById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/find_one/{id}")
    public ResponseEntity<Book> findOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(bookService.findOne(id));
    }
 }
