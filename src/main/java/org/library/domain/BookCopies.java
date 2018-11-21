package org.library.domain;

import javax.persistence.*;

@Entity
@Table(name = "BOOK_COPIES")
public class BookCopies {

    private int id;
    private BorrowStatus status;
    private Book book;


    public BookCopies(BorrowStatus status, Book book) {
        this.status = status;
        this.book = book;
    }

    public BookCopies() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public BorrowStatus getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
