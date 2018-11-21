package org.library.domain;

import java.util.Date;

public class BorrowedCopyDto {

    private int id;
    private BookCopies bookCopiesId;
    private Reader readerId;
    private Date borrowStart;
    private Date borrowEnd;

    public BorrowedCopyDto(int id, BookCopies bookCopiesId, Reader readerId, Date borrowStart, Date borrowEnd) {
        this.id = id;
        this.bookCopiesId = bookCopiesId;
        this.readerId = readerId;
        this.borrowStart = borrowStart;
        this.borrowEnd = borrowEnd;
    }

    public BorrowedCopyDto() {
    }

    public int getId() {
        return this.id;
    }

    public BookCopies getBookCopiesId() {
        return this.bookCopiesId;
    }

    public Reader getReaderId() {
        return this.readerId;
    }

    public Date getBorrowStart() {
        return this.borrowStart;
    }

    public Date getBorrowEnd() {
        return this.borrowEnd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookCopiesId(BookCopies bookCopiesId) {
        this.bookCopiesId = bookCopiesId;
    }

    public void setReaderId(Reader readerId) {
        this.readerId = readerId;
    }

    public void setBorrowStart(Date borrowStart) {
        this.borrowStart = borrowStart;
    }

    public void setBorrowEnd(Date borrowEnd) {
        this.borrowEnd = borrowEnd;
    }
}
