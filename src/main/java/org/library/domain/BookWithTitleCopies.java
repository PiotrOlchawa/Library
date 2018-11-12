package org.library.domain;

import lombok.Getter;

@Getter
public class BookWithTitleCopies {

    private Integer id;
    private String title;
    private Integer copies;

    public BookWithTitleCopies(Integer id, String title, Integer copies) {
        this.id = id;
        this.title = title;
        this.copies = copies;
    }
}
