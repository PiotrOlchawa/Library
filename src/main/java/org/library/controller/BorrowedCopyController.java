package org.library.controller;

import org.library.domain.dto.BorrowedCopyDto;
import org.library.service.BorrowedCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class BorrowedCopyController {

    @Autowired
    BorrowedCopyService borrowedCopyService;

    @RequestMapping(method = RequestMethod.POST, value = "/borrow")
    void borrowBook(@RequestParam Integer bookId, @RequestParam Integer readerId) {
        borrowedCopyService.borrowCopy(readerId,bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/return")
    void returnBook(@RequestParam Integer bookId, @RequestParam Integer readerId) {
        borrowedCopyService.returnCopy(readerId,bookId);
    }

}
