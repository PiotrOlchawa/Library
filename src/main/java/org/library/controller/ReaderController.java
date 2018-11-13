package org.library.controller;

import org.library.domain.dto.ReaderDto;
import org.library.service.ReaderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ReaderController.class);
    @Autowired
    ReaderService readerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ReaderDto> getReaders() {
        return readerService.getReaders();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        readerService.saveReader(readerDto);
    }
}
