package org.library.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.Book;
import org.library.domain.BookCopies;
import org.library.domain.BookCopiesDto;
import org.library.domain.BorrowStatus;
import org.library.mapper.BookCopiesMapper;
import org.library.mapper.BookMapper;
import org.library.repository.BookCopiesDao;
import org.library.repository.BookDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookCopiesServiceTest {

    @InjectMocks
    BookCopiesService bookCopiesService;
    @Mock
    BookCopiesDao bookCopiesDao;
    @Mock
    BookCopiesMapper bookCopiesMapper;

    @Test
    public void changeBookStatus() {
        //Given
        Book book = new Book();
        BookCopiesDto bookCopiesDto = new BookCopiesDto(1,BorrowStatus.AVAILABLE,book);
        BookCopies bookCopies = new BookCopies(bookCopiesDto.getStatus(),book);
        bookCopies.setId(bookCopiesDto.getId());
        //When
        when(bookCopiesDao.findById(bookCopiesDto.getId())).thenReturn(bookCopies);
        when(bookCopiesDao.save(bookCopies)).thenReturn(bookCopies);
        when(bookCopiesMapper.mapBookCopiesToBookCopiesDto(bookCopies)).thenReturn(bookCopiesDto);
        BookCopiesDto bookCopiesDto1 = bookCopiesService.changeBookStatus(bookCopiesDto);
        //Then
        Assert.assertEquals(1,bookCopiesDto1.getId());
    }
}