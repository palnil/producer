package com.yoshallc.producer.controller;

import com.yoshallc.producer.controller.request.BookRequest;
import com.yoshallc.producer.dto.BookDto;
import com.yoshallc.producer.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<BookDto> getBooks(@RequestBody BookRequest booksRequest){

        BookDto book = bookService.getBook(booksRequest.getName());
        return new ResponseEntity <BookDto>(book, HttpStatus.OK);

    }
}
