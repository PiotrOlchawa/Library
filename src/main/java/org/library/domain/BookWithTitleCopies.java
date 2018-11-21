package org.library.domain;

public class BookWithTitleCopies {

    private Integer id;
    private String title;
    private Integer copies;

    public BookWithTitleCopies(Integer id, String title, Integer copies) {
        this.id = id;
        this.title = title;
        this.copies = copies;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getCopies() {
        return this.copies;
    }
}
