package org.library.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.Book;
import org.library.domain.BookCopies;
import org.library.domain.BorrowStatus;
import org.library.domain.Reader;
import org.library.mapper.BorrowedCopyMapper;
import org.library.repository.BookCopiesDao;
import org.library.repository.BookDao;
import org.library.repository.BorrowedCopyDao;
import org.library.repository.ReaderDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BorrowedCopyServiceTest {

    @InjectMocks
    BorrowedCopyService borrowedCopyService;
    @Mock
    ReaderDao readerDao;
    @Mock
    BookDao bookDao;
    @Mock
    BookCopiesDao bookCopiesDao;

    @Test
    public void borrowCopy() {
        //Given
        Book book = new Book();
        Reader reader = new Reader();
        book.setId(1);
        reader.setId(1);
        BookCopies firstAvailiableCopy = new BookCopies(BorrowStatus.AVAILABLE, book);
        List<BookCopies> bookCopiesList = new ArrayList<>();
        bookCopiesList.add(firstAvailiableCopy);
        firstAvailiableCopy.setId(1);
        //When
        when(bookDao.findById(1)).thenReturn(book);
        when(readerDao.findById(1)).thenReturn(reader);
        when(bookCopiesDao.findByBook(book)).thenReturn(bookCopiesList);
        borrowedCopyService.borrowCopy(1, 1);
        //Then
        Assert.assertEquals(BorrowStatus.BORROWED, bookCopiesList.get(0).getStatus());
    }

}