package com.example.bookmicroservice.controller;

import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class BookController {

    public final BookService bookService;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() throws ExecutionException, InterruptedException {

        return bookService.getAllBooks();
    }



}
