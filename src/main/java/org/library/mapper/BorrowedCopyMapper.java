package org.library.mapper;

import org.library.domain.BorrowedCopy;
import org.library.domain.BorrowedCopyDto;
import org.springframework.stereotype.Component;

@Component
public class BorrowedCopyMapper {

    public BorrowedCopyDto mapBorrowedCopyToBorrowedCopyDto(BorrowedCopy borrowedCopy) {
        return new BorrowedCopyDto(borrowedCopy.getId(),
                borrowedCopy.getBookCopies(),
                borrowedCopy.getReader(),
                borrowedCopy.getBorrowStart(),
                borrowedCopy.getBorrowEnd());
    }
}
