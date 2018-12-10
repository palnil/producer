package com.yoshallc.producer.service;

import com.yoshallc.producer.dto.BookDto;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public  BookDto getBook(String name) {

        List <BookDto> books = new ArrayList();

        books.add(new BookDto(1L , "Harry Porter"));
        books.add(new BookDto(2L , "Shade"));
        books.add(new BookDto(3L , "Fear"));

        for(BookDto book : books) {

            if(book.getName() == name)
                return book;
        }

        return null;
    }
}
