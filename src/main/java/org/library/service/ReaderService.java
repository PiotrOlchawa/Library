package org.library.service;

import org.library.domain.Reader;
import org.library.domain.ReaderDto;
import org.library.exception.ReaderNotAvailableException;
import org.library.mapper.ReaderMapper;
import org.library.repository.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {
    @Autowired
    ReaderDao readerDao;
    @Autowired
    ReaderMapper readerMapper;

    public List<ReaderDto> getReaders() {
        return Optional.ofNullable(readerMapper.mapReaderListToReaderListDto(readerDao.findAll()))
                .orElseThrow(ReaderNotAvailableException::new);
    }

    public ReaderDto saveReader(ReaderDto readerDto) {
        Reader reader = readerDao.save(readerMapper.mapReaderDtoToReader(readerDto));
        return readerMapper.mapReaderToReaderDto(reader);
    }
}
