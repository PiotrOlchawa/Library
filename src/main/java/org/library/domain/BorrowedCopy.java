package org.library.domain;

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
    private BookCopies bookCopies;

    private Reader reader;
    private Date borrowStart;
    private Date borrowEnd;
    private int id;

    public BorrowedCopy(Date borrowStart, Date borrowEnd) {
        this.borrowStart = borrowStart;
        this.borrowEnd = borrowEnd;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID",unique = true)
    @NotNull
    public int getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TITLE_COPIES_ID")
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
