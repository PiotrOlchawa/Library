package org.library.controller;

import org.library.domain.dto.BookCopiesDto;
import org.library.service.BookCopiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookcopies")
public class BookCopiesController {

    @Autowired
    BookCopiesService bookCopiesService;

    @RequestMapping(method = RequestMethod.PUT)
    void changeStatus(@RequestBody BookCopiesDto bookCopiesDto) {
        bookCopiesService.changeBookStatus(bookCopiesDto);
    }

}
