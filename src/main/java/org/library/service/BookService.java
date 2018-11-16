package org.library.service;

import org.library.domain.Book;
import org.library.domain.BookCopies;
import org.library.domain.BorrowStatus;
import org.library.domain.dto.BookDto;
import org.library.domain.BookWithTitleCopies;
import org.library.exception.BookNotAvailableException;
import org.library.mapper.BookMapper;
import org.library.repository.BookCopiesDao;
import org.library.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookCopiesDao bookCopiesDao;

    public void saveBook(BookDto bookDto) {
        Book book = bookMapper.mapBookDtoToBook(bookDto);
        bookDao.save(book);
    }

    public void addBookToBookCopies(Integer bookId) {
        Book book = Optional.ofNullable(bookDao.findOne(bookId)).orElseThrow(BookNotAvailableException::new);
        BookCopies bookCopies = new BookCopies(BorrowStatus.AVAILABLE, book);
        bookCopiesDao.save(bookCopies);
    }

    public List<BookDto> getBooks() {
        System.out.println(bookDao.findAll().size());
        return bookMapper.mapBookListToBookDtoList(bookDao.findAll());

    }

    public BookDto getBook(Integer id) {
        return bookMapper.mapBookToBookDto(bookDao.findById(id));
    }

    public List<BookWithTitleCopies> getBookWithTitle(String title) {
        List<Book> bookList = bookDao.retrieveBookWithTitle("%" + title + "%");

        bookList = bookList.stream()
                .filter(b -> b.getBookCopies().stream()
                        .filter(d -> d.getStatus() == BorrowStatus.AVAILABLE)
                        .count() > 0)
                .collect(Collectors.toList());

        Optional.ofNullable(bookList).orElseThrow(BookNotAvailableException::new);

        return bookMapper.mapBookToBookWithTitleCopiesDto(bookList);
    }
}
