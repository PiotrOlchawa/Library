package org.library.mapper;

import org.library.domain.BookCopies;
import org.library.domain.dto.BookCopiesDto;

public class BookCopiesMapper {

    public BookCopies mapBookCopiesDtoToBookCopies(BookCopiesDto bookCopiesDto){
        return new BookCopies(bookCopiesDto.getStatus(),bookCopiesDto.getBook());
    }
}
