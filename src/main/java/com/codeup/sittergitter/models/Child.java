package com.codeup.sittergitter.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="children")
public class Child {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @Column
    private String special_note;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private User parent;

    public Child() {}

    public Child(String name, Date birthdate, String special_note, User parent) {
        this.name = name;
        this.birthdate = birthdate;
        this.special_note = special_note;
        this.parent = parent;
    }

    public String getSpecial_note() {
        return special_note;
    }

    public void setSpecial_note(String special_note) {
        this.special_note = special_note;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return special_note;
    }

    public void setSpecialNote(String special_note) {
        this.special_note = special_note;
    }

    public User getUser() {
        return parent;
    }

    public void setUser(User user) {
        this.parent = user;
    }
}
