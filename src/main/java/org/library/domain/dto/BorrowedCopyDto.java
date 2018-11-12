package org.library.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.library.domain.Reader;

import java.util.Date;

@Setter
@Getter
public class BorrowedCopyDto {

    private Reader readerId;
    private Date borrowStart;
    private Date borrowEnd;
    private int id;

}
