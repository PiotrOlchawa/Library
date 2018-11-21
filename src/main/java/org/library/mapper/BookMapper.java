package org.library.mapper;

import org.library.domain.Book;
import org.library.domain.BookCopies;
import org.library.domain.BorrowStatus;
import org.library.domain.BookDto;
import org.library.domain.BookWithTitleCopies;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {


    public Book mapBookDtoToBook(BookDto bookDto) {
        List<BookCopies> bookCopiesList = new ArrayList<>();
        BookCopies bookCopies = new BookCopies();
        bookCopies.setStatus(BorrowStatus.AVAILABLE);
        bookCopiesList.add(bookCopies);
        Book book = new Book(bookDto.getTitle(),bookDto.getAuthor(),bookDto.getPubYear());
        book.setBookCopies(bookCopiesList);
        return book;
    }

    public List<BookDto> mapBookListToBookDtoList(List<Book> bookList){

        return bookList.stream().map(book -> new BookDto(book.getId(),book.getTitle(),book.getAuthor(),book.getPubYear()))
                .collect(Collectors.toList());
    }

    public BookDto mapBookToBookDto(Book book) {
        return new BookDto(book.getId(),book.getTitle(),book.getAuthor(),book.getPubYear());
    }

    public List<BookWithTitleCopies> mapBookToBookWithTitleCopiesDto(List<Book> bookList) {
        return bookList.stream()
                .map(book -> new BookWithTitleCopies(book.getId(),
                        book.getTitle(),
                        book.getBookCopies().size()))
                .collect(Collectors.toList());
    }


}
