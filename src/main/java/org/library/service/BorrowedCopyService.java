package org.library.service;

import org.library.domain.*;
import org.library.domain.BorrowedCopyDto;
import org.library.exception.BookNotAvailableException;
import org.library.exception.BorrowedCopyNotAvailableException;
import org.library.exception.ReaderNotAvailableException;
import org.library.mapper.BorrowedCopyMapper;
import org.library.repository.BookCopiesDao;
import org.library.repository.BookDao;
import org.library.repository.BorrowedCopyDao;
import org.library.repository.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowedCopyService {

    @Autowired
    BookCopiesDao bookCopiesDao;
    @Autowired
    BorrowedCopyDao borrowedCopyDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    ReaderDao readerDao;
    @Autowired
    BorrowedCopyMapper borrowedCopyMapper;

    Reader reader;
    Book book;

    public BorrowedCopyDto borrowCopy(Integer readerId, Integer bookId) {


        setBook(bookId);
        setReader(readerId);

        List<BookCopies> bookCopiesList = bookCopiesDao.findByBook(book);

        BookCopies firstAvailableCopy = bookCopiesList.stream()
                .filter(bookCopies -> bookCopies.getStatus() == BorrowStatus.AVAILABLE)
                .findFirst()
                .orElseThrow(BookNotAvailableException::new);
        firstAvailableCopy.setStatus(BorrowStatus.BORROWED);
        bookCopiesDao.save(firstAvailableCopy);
        BorrowedCopy borrowedCopy = new BorrowedCopy(new Date(), firstAvailableCopy, reader);
        return borrowedCopyMapper
                .mapBorrowedCopyToBorrowedCopyDto(borrowedCopyDao.save(borrowedCopy));
    }

    public BorrowedCopyDto returnCopy(Integer readerId, Integer bookId) {
        setBook(bookId);
        setReader(readerId);

        BookCopies bookCopies = bookCopiesDao.findByStatusAndBook(BorrowStatus.BORROWED, book);

        bookCopies.setStatus(BorrowStatus.AVAILABLE);
        bookCopiesDao.save(bookCopies);
        List<BorrowedCopy> borrowedCopyList = Optional.ofNullable(borrowedCopyDao.findByReaderAndBookCopies(reader, bookCopies))
                .orElseThrow(BorrowedCopyNotAvailableException::new);
        BorrowedCopy borrowedCopy = borrowedCopyList.stream()
                .filter(borrowed -> borrowed.getBorrowEnd() == null)
                .findFirst().orElseThrow(BorrowedCopyNotAvailableException::new);
        borrowedCopy.setBorrowEnd(new Date());
        return borrowedCopyMapper
                .mapBorrowedCopyToBorrowedCopyDto(borrowedCopyDao.save(borrowedCopy));
    }

    private void setBook(Integer bookId) {
        book = Optional.ofNullable(bookDao.findById(bookId))
                .orElseThrow(BookNotAvailableException::new);
    }

    private void setReader(Integer readerId) {
        reader = Optional.ofNullable(readerDao.findById(readerId))
                .orElseThrow(ReaderNotAvailableException::new);
    }
}
