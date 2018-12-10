package com.yoshallc.producer.controller;

import com.yoshallc.producer.dto.BookDto;
import com.yoshallc.producer.service.BookService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.awt.print.Book;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BaseTest {


    @Autowired
    BookController bookController;

    @MockBean
    BookService bookService;

    @BeforeEach
    public void setUp(){

        BookDto bookDto = new BookDto(1L , "Harry Porter");

        when(bookService.getBook(any(Long.class))).thenReturn(bookDto);


        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders
                .standaloneSetup(bookController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

}
