package org.library.repository.dao;

import org.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookDao extends CrudRepository<Book,Integer> {

    List<Book> findAll();
    List<Book> findByTitle(String title);
}
