package org.library.repository.dao;

import org.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReaderDao extends CrudRepository<Reader,Integer> {
   List<Reader> findAll();
}
