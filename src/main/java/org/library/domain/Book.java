package org.library.domain;


import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@NamedQuery(
        name = "Book.retrieveBookWithTitle",
        query = "FROM Book WHERE title like :TITLE")

@Setter
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {

    private int id;
    private String title;
    private String author;
    private int pubYear;
    private List<BookCopies> bookCopies = new ArrayList<>();

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
}
