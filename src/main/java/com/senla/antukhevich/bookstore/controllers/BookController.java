package com.senla.antukhevich.bookstore.controllers;


import com.senla.antukhevich.bookstore.service.BookService;
import com.senla.antukhevich.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    OrderService orderService;

    @Autowired
    BookService bookService;


}
