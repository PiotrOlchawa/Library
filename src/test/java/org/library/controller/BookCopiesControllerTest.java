package org.library.controller;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.Book;
import org.library.domain.BookCopies;
import org.library.domain.BookWithTitleCopies;
import org.library.domain.BorrowStatus;
import org.library.domain.dto.BookCopiesDto;
import org.library.domain.dto.BookDto;
import org.library.mapper.BookCopiesMapper;
import org.library.mapper.BookMapper;
import org.library.repository.BookCopiesDao;
import org.library.service.BookCopiesService;
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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookCopiesController.class)
public class BookCopiesControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    BookService bookService;
    @MockBean
    BookCopiesService bookCopiesService;
    @MockBean
    BookMapper bookMapper;
    @MockBean
    BookCopiesMapper bookCopiesMapper;


    @Test
    public void changeStatus() throws Exception {
        //Given
        Book book = new Book("title","author",2003);
        book.setId(1);
        BookCopiesDto bookCopiesDto = new BookCopiesDto(1,BorrowStatus.NOT_AVAILABLE, book);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookCopiesDto);
        //When&Then
        mockMvc.perform(put("/bookcopies/changeBookStatus")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void getBookWithSpecifiedTitle() throws Exception {
        //Given
        Book book = new Book("Oitle", "author", 1999);
        bookService.saveBook(bookMapper.mapBookToBookDto(book));
        BookCopies bookCopies = new BookCopies(BorrowStatus.AVAILABLE, book);
        bookCopiesService.saveBookCopy(bookCopies);
        // When&&Then
        mockMvc.perform(get("/bookcopies/tit")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.title", is("Oitle")));
    }

    @Test
    public void addBookCopies() throws Exception {
        //Given
        Gson gson = new Gson();
        String jsonContent = gson.toJson(null);
        //When&Then
        mockMvc.perform(post("/bookcopies/addCopy/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}