package org.library.mapper;

import org.library.domain.BookCopies;
import org.library.domain.BookCopiesDto;
import org.springframework.stereotype.Component;

@Component
public class BookCopiesMapper {

    public BookCopies mapBookCopiesDtoToBookCopies(BookCopiesDto bookCopiesDto){
        return new BookCopies(bookCopiesDto.getStatus(),bookCopiesDto.getBook());
    }

    public BookCopiesDto mapBookCopiesToBookCopiesDto(BookCopies bookCopies) {
    return new BookCopiesDto(bookCopies.getId(),bookCopies.getStatus(),bookCopies.getBook());

    }
}
