package org.library.repository;

import org.library.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookDao extends CrudRepository<Book,Integer> {

    @Override
    List<Book> findAll();

    @Override
    Book save(Book bookDao);

    List<Book> findByTitle(String title);

    Book findById(Integer id);

    @Query
    List<Book> retrieveBookWithTitle(@Param("TITLE") String title);
}
