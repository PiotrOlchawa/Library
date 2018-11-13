package org.library.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Setter
@Entity
@Table(name = "BORROWED_COPY")
public class BorrowedCopy {

    private int id;
    private Date borrowStart;
    private Date borrowEnd;
    private BookCopies bookCopies;
    private Reader reader;

    public BorrowedCopy(Date borrowStart, BookCopies bookCopies, Reader reader) {
        this.borrowStart = borrowStart;
        this.bookCopies = bookCopies;
        this.reader = reader;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID",unique = true)
    @NotNull
    public int getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_COPIES_ID")
    public BookCopies getBookCopies() {
        return bookCopies;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "READER_ID")
    public Reader getReader() {
        return reader;
    }

    @Column(name = "BORROW_START")
    public Date getBorrowStart() {
        return borrowStart;
    }

    @Column(name = "BORROW_END")
    public Date getBorrowEnd() {
        return borrowEnd;
    }

}
