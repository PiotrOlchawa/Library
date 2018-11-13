package org.library.service;

import org.library.domain.BookCopies;
import org.library.domain.dto.BookCopiesDto;
import org.library.repository.BookCopiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCopiesService {

    @Autowired
    BookCopiesDao bookCopiesDao;

    public void changeBookStatus(BookCopiesDto bookCopiesDto) {
        BookCopies bookCopies = bookCopiesDao.findById(bookCopiesDto.getId());
        bookCopies.setStatus(bookCopiesDto.getStatus());
        bookCopiesDao.save(bookCopies);
    }
}
