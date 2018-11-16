package org.library.controller;

import org.library.domain.dto.BookDto;
import org.library.domain.BookWithTitleCopies;
import org.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public BookDto getBook(@PathVariable Integer bookId) {
        return bookService.getBook(bookId);
    }

    @RequestMapping(
            method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void saveBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookDto);
    }


}
