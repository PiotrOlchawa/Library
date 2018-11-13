package org.library.repository;

import org.library.domain.Book;
import org.library.domain.BookCopies;
import org.library.domain.BorrowedCopy;
import org.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BorrowedCopyDao extends CrudRepository<BorrowedCopy,Integer> {

    @Override
    List<BorrowedCopy> findAll();

    @Override
    BorrowedCopy save(BorrowedCopy borrowedCopy);

    List<BorrowedCopy> findByReaderAndBookCopies(Reader reader,BookCopies bookCopies);

}
