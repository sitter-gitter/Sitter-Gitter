package com.codeup.sittergitter.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="children")
public class Child {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @Column
    private String specialNote;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private User parent;

    public Child() {}

    public Child(String name, Date birthdate, String specialNote, User user) {
        this.name = name;
        this.birthdate = birthdate;
        this.specialNote = specialNote;
        this.parent = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }

    public User getUser() {
        return parent;
    }

    public void setUser(User user) {
        this.parent = user;
    }
}
