package org.library.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.Reader;
import org.library.domain.ReaderDto;
import org.library.mapper.ReaderMapper;
import org.library.repository.ReaderDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReaderServiceTest {

    @InjectMocks
    ReaderService readerService;
    @Mock
    ReaderDao readerDao;
    @Mock
    ReaderMapper readerMapper;

    @Test
    public void getReaders() {
        //Given
        Date date = new Date();
        ReaderDto [] readerDtosArray = {new ReaderDto(1, "name", "lastName", date)};
        Reader reader = new Reader();
        reader.setId(1);
        reader.setDate(date);
        reader.setName("name");
        reader.setLastName("lastName");
        Reader [] readersArray = {reader};
        List<Reader> readerList = Arrays.asList(readersArray);
        List<ReaderDto> readerDtoList = Arrays.asList(readerDtosArray);
        //When
        when(readerDao.findAll()).thenReturn(readerList);
        when(readerMapper.mapReaderListToReaderListDto(readerList)).thenReturn(readerDtoList);
        List<ReaderDto> allReaders = readerService.getReaders();
        //Then
        Assert.assertEquals(1,allReaders.size());
    }

   @Test
    public void saveReader() {
        //Given
        Date date = new Date();
        ReaderDto readerDto = new ReaderDto(1, "name", "lastName", date);
        Reader reader = new Reader();
        reader.setId(1);
        reader.setDate(date);
        reader.setName("name");
        reader.setLastName("lastName");
        //When
        when(readerMapper.mapReaderDtoToReader(readerDto)).thenReturn(reader);
        when(readerService.saveReader(readerDto)).thenReturn(readerDto);
        ReaderDto returningReaderDto = readerService.saveReader(readerDto);
        //Then
        Assert.assertEquals(1,returningReaderDto.getId());
    }
}