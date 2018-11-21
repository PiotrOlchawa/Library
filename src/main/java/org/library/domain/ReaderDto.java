package org.library.domain;

import java.util.Date;

public class ReaderDto {

    private int id;
    private String name;
    private String lastName;
    private Date date;

    public ReaderDto() {
    }

    public ReaderDto(int id, String name, String lastName, Date date) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getDate() {
        return this.date;
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
