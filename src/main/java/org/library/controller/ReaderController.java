package org.library.controller;

import org.library.domain.Reader;
import org.library.domain.dto.ReaderDto;
import org.library.mapper.ReaderMapper;
import org.library.service.ReaderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/library")
public class ReaderController {
/*
    dodanie czytelnika : dadanie ob. Reader
 */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ReaderController.class);
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    ReaderService readerService;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapReaderListToReaderDtoList(readerService.getReaders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader")
    public void createReader(@RequestBody ReaderDto readerDto){
        readerMapper.mapReaderDtoToReader(readerDto);
    }



}
