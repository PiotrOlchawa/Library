package org.library.controller;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.Book;
import org.library.domain.dto.BookDto;
import org.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    BookService bookService;


    @Test
    public void getBooks() throws Exception {
        //Given
        BookDto book = new BookDto(1,"title","author",2003);
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(book);
        //When&Then
        when(bookService.getBooks()).thenReturn(bookDtos);
        mockMvc.perform(get("/book").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("title")))
                .andExpect(jsonPath("$[0].author", is("author")))
                .andExpect(jsonPath("$[0].pubYear", is(2003)));
    }

    @Test
    public void getBook() throws Exception {
        //Given
        BookDto bookDto = new BookDto(1,"title","author",2003);
        when(bookService.getBook(1)).thenReturn(bookDto);
        //When&Then
        mockMvc.perform(get("/book/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("title")))
                .andExpect(jsonPath("$.author", is("author")))
                .andExpect(jsonPath("$.pubYear", is(2003)));
    }


    @Test
    public void saveBook() throws Exception {
        //Given
        BookDto bookDto = new BookDto(100,"title","author",2003);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);
        //When&Then
        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}