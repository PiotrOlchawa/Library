package org.library.controller;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.ReaderDto;
import org.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReaderController.class)
public class ReaderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ReaderService readerService;

    @Test
    public void getReaders() throws Exception {
        //Given
        ReaderDto readerDto = new ReaderDto(1, "title", "author", new Date());
        List<ReaderDto> readerDtos = new ArrayList<>();
        readerDtos.add(readerDto);
        //When&Then
        when(readerService.getReaders()).thenReturn(readerDtos);
        mockMvc.perform(get("/reader").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("title")))
                .andExpect(jsonPath("$[0].lastName", is("author")));
    }

    @Test
    public void createReader() throws Exception {
        //Given
        ReaderDto readerDto = new ReaderDto(100, "title", "author", new Date());
        Gson gson = new Gson();
        String jsonContent = gson.toJson(readerDto);
        when(readerService.saveReader(readerDto)).thenReturn(readerDto);
        //When&Then
        mockMvc.perform(post("/reader/createReader")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}