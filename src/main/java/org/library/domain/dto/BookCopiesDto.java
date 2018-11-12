package org.library.domain.dto;

import org.library.domain.Book;
import org.library.domain.BorrowStatus;

public class BookCopiesDto {

    private int id;
    private BorrowStatus status;
    private Book book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
