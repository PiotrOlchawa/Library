package org.library.controller;

import org.library.domain.BookWithTitleCopies;
import org.library.domain.BookCopiesDto;
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

    @RequestMapping(method = RequestMethod.PUT, value = "/changeBookStatus")
    public BookCopiesDto changeStatus(@RequestBody BookCopiesDto bookCopiesDto) {
        return bookCopiesService.changeBookStatus(bookCopiesDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookWithTitleCopies> getBookWithSpecifiedTitle(@RequestParam("title") String titleLike) {
        return bookService.getBookWithTitle(titleLike);
    }

    @RequestMapping(
            method = RequestMethod.POST, value = "/addCopy/{bookId}",
            consumes = APPLICATION_JSON_VALUE)
    public void addBookCopies(@PathVariable Integer bookId) {
        bookService.addBookToBookCopies(bookId);
    }

}
