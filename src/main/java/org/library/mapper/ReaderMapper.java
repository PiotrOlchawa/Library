package org.library.mapper;

import org.library.domain.Reader;
import org.library.domain.dto.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    public ReaderDto mapReaderToReaderDto(Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getLastName(),
                reader.getDate());
    }

    public List<ReaderDto> mapReaderListToReaderDtoList(List<Reader> readers) {

        return readers.stream()
                .map(reader -> new ReaderDto(
                        reader.getId(),
                        reader.getName(),
                        reader.getLastName(),
                        reader.getDate()))
                .collect(Collectors.toList());
    }

    public void mapReaderDtoToReader(ReaderDto readerDto) {

    }
}
