package org.library.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.Book;
import org.library.domain.BookCopies;
import org.library.domain.BookWithTitleCopies;
import org.library.domain.BorrowStatus;
import org.library.domain.dto.BookDto;
import org.library.mapper.BookMapper;
import org.library.repository.BookDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;
    @Mock
    BookDao bookDao;
    @Mock
    BookMapper bookMapper;

    @Test
    public void getBooks() {
        //Given
        Book[] bookArray = {new Book("book1", "author", 1997)};
        BookDto[] bookDtosArray = {new BookDto(1, "title", "autor", 1997)};
        List<Book> bookList = Arrays.asList(bookArray);
        List<BookDto> bookDtoList = Arrays.asList(bookDtosArray);

        //When
        when(bookDao.findAll()).thenReturn(bookList);
        when(bookMapper.mapBookListToBookDtoList(bookList)).thenReturn(bookDtoList);
        List<BookDto> bookDtos = bookService.getBooks();
        //Then
        Assert.assertEquals(1, bookDtos.size());
    }

    @Test
    public void getBook() {
        //Given
        Book book = new Book("book1", "author", 1997);
        BookDto bookDto = new BookDto(1, "title", "autor", 1997);

        //When
        when(bookDao.findById(1)).thenReturn(book);
        when(bookMapper.mapBookToBookDto(book)).thenReturn(bookDto);
        BookDto serviceBookDto = bookService.getBook(1);

        //Then
        Assert.assertEquals(1, serviceBookDto.getId());
    }

    @Test
    public void getBookWithTitle() {
        //Given
        String searchTitle = "boo";
        Book book = new Book("book1", "author", 1997);
        Book book1 = new Book("book2", "author", 1997);
        book.getBookCopies().add(new BookCopies(BorrowStatus.AVAILABLE, book));
        book1.getBookCopies().add(new BookCopies(BorrowStatus.AVAILABLE, book1));
        Book[] booksWithTitle = {book, book1};
        List<Book> bookWithTitleList = Arrays.asList(booksWithTitle);

        BookWithTitleCopies[] bookWithTitleCopiesArray = {new BookWithTitleCopies(1, "book1", 1),
                new BookWithTitleCopies(1, "book1", 1)};
        List<BookWithTitleCopies> bookWithTitleCopiesList = Arrays.asList(bookWithTitleCopiesArray);

        //When
        when(bookDao.retrieveBookWithTitle("%" + searchTitle + "%")).thenReturn(bookWithTitleList);
        when(bookMapper.mapBookToBookWithTitleCopiesDto(bookWithTitleList)).thenReturn(bookWithTitleCopiesList);
        List<BookWithTitleCopies> bookWithTitleCopies = bookService.getBookWithTitle(searchTitle);

        //Then
        Assert.assertEquals(2, bookWithTitleCopies.size());
    }
}