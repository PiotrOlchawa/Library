package org.library.controller;

import org.library.domain.dto.BorrowedCopyDto;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/borrow")
public class BorrowedCopyController {

    @RequestMapping(method = RequestMethod.POST, value = "/borrow", consumes = APPLICATION_JSON_VALUE)
    void borrowBook(@RequestBody BorrowedCopyDto borrowedCopyDto) {


    }

    @RequestMapping(method = RequestMethod.PUT, value = "/return/{borrowId}")
    void returnBook(@PathVariable Integer borrowId) {

    }


}
