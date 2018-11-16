package org.library.controller;

import org.library.domain.BookWithTitleCopies;
import org.library.domain.dto.BookCopiesDto;
import org.library.service.BookCopiesService;
import org.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/bookcopies")
public class BookCopiesController {

    @Autowired
    BookCopiesService bookCopiesService;
    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.PUT, value="/changeBookStatus")
    void changeStatus(@RequestBody BookCopiesDto bookCopiesDto) {
        bookCopiesService.changeBookStatus(bookCopiesDto);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{titleLike}")
    public List<BookWithTitleCopies> getBookWithSpecifiedTitle(@PathVariable String titleLike) {
        return bookService.getBookWithTitle(titleLike);
    }

    @RequestMapping(
            method = RequestMethod.POST, value = "/addCopy/{bookId}",
            consumes = APPLICATION_JSON_VALUE)
    public void addBookCopies(@PathVariable Integer bookId) {
        bookService.addBookToBookCopies(bookId);
    }

}
