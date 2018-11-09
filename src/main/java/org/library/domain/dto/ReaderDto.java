package org.library.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReaderDto {

    private int id;
    private String name;
    private String lastName;
    private Date date;

    public ReaderDto(int id, String name, String lastName, Date date) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
    }

}
