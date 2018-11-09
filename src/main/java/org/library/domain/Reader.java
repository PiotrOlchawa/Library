package org.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "READER")
public class Reader {

    private int id;
    private String name;
    private String lastName;
    private Date date;

    public Reader(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.date = new Date();
    }

    public Reader() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID" , unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @NotNull
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }
    @NotNull
    @Column(name = "DATE")

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
