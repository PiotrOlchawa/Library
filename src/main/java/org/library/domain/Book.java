package org.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Book.retrieveBookWithTitle",
        query = "FROM Book WHERE title like :TITLE")

@Entity
@Table(name = "BOOK")
public class Book {

    private int id;
    private String title;
    private String author;
    private int pubYear;
    private List<BookCopies> bookCopies = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String author, int pubYear) {
        this.title = title;
        this.author = author;
        this.pubYear = pubYear;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    @NotNull
    public int getId() {
        return id;
    }

    @Column(name = "TITLE")
    @NotNull
    public String getTitle() {
        return title;
    }

    @Column(name = "AUTHOR")
    @NotNull
    public String getAuthor() {
        return author;
    }

    @Column(name = "PUB_YEAR")
    @NotNull
    public int getPubYear() {
        return pubYear;
    }

    @OneToMany(
            targetEntity = BookCopies.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<BookCopies> getBookCopies() {
        return bookCopies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public void setBookCopies(List<BookCopies> bookCopies) {
        this.bookCopies = bookCopies;
    }
}
