package com.yoshallc.producer.service;

import com.yoshallc.producer.dto.BookDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp(){

        this.bookService = new BookService();
    }

    @Test
    public void whenCalled_getBooks_ShouldReturn_MatchingBook(){

        assertNotNull(bookService.getBook(2L));
        assertEquals(bookService.getBook(1L).toString(),new BookDto(1L,"Harry Porter").toString());
    }

    @Test
    public void whenCalled_GetBooks_AndPassedWrongID_ShouldReturnNull(){

        assertNull(bookService.getBook(5L));

    }
}