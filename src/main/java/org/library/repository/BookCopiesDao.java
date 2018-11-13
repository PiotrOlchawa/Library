package org.library.repository;

import org.library.domain.Book;
import org.library.domain.BookCopies;
import org.library.domain.BorrowStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookCopiesDao extends CrudRepository<BookCopies, Integer> {

    @Override
    List<BookCopies> findAll();

    @Override
    BookCopies save(BookCopies bookCopies);

    BookCopies findById(Integer bookCopiesId);

    List<BookCopies> findByBook(Book book);

    BookCopies findByStatusAndBook(BorrowStatus borrowStatus, Book book);

}
