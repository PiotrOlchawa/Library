package org.library.service;

import org.library.domain.Reader;
import org.library.repository.dao.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    @Autowired
    ReaderDao readerDao;

    public List<Reader> getReaders() {
        return readerDao.findAll();
    }
}