package org.library.repository.dao;

import org.library.domain.BookCopies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookCopiesDao extends CrudRepository<BookCopies,Integer> {
    List<BookCopies> findAll();
}
