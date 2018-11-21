package org.library.controller;

import org.library.domain.BorrowedCopyDto;
import org.library.service.BorrowedCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BorrowedCopyController {

    @Autowired
    BorrowedCopyService borrowedCopyService;

    @RequestMapping(method = RequestMethod.POST, value = "/borrow")
    BorrowedCopyDto borrowBook(@RequestParam Integer bookId, @RequestParam Integer readerId) {
        return borrowedCopyService.borrowCopy(readerId, bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/return")
    BorrowedCopyDto returnBook(@RequestParam Integer bookId, @RequestParam Integer readerId) {
        return borrowedCopyService.returnCopy(readerId, bookId);
    }
}
