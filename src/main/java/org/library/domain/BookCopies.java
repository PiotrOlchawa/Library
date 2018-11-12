package org.library.domain;

import lombok.Setter;
import javax.persistence.*;

@Setter
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
    @Column(name = "ID",unique = true)
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
}
