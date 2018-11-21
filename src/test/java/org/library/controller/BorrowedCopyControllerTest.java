package org.library.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.BorrowedCopyDto;
import org.library.service.BorrowedCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BorrowedCopyController.class)
public class BorrowedCopyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    BorrowedCopyService borrowedCopyService;

    @Test
    public void borrowBook() throws Exception {
        //Given
        BorrowedCopyDto borrowedCopyDto = new BorrowedCopyDto();
        borrowedCopyDto.setId(1);
        when(borrowedCopyService.borrowCopy(1, 1)).thenReturn(borrowedCopyDto);
        //When&Then
        mockMvc.perform(post("/borrow?bookId=1&readerId=1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void returnBook() throws Exception {
        //Given
        BorrowedCopyDto borrowedCopyDto = new BorrowedCopyDto();
        borrowedCopyDto.setId(1);
        when(borrowedCopyService.returnCopy(1, 1)).thenReturn(borrowedCopyDto);
        //When&Then
        mockMvc.perform(put("/return?bookId=1&readerId=1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }
}