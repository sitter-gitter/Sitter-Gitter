package com.codeup.sittergitter.models;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 100, name = "title")
    private String title;
    @Column(nullable = false)
    private String body;
    @Column
    private Boolean is_recommended;

    @ManyToOne
    @JoinColumn (name = "author_id", referencedColumnName="id")
    private User author;

    // C in CRUD
    public Review() {
    }

    // R in CRUD
    public Review(Long id, String title, String body, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    // U in CRUD
    public Review(String title, String body, User author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    // D in CRUD
    public Review(Long id) {
        this.id = id;
    }

    public Review(String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Review(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Review(String title, String body, Boolean is_recommended, User author) {
        this.title = title;
        this.body = body;
        this.is_recommended = is_recommended;
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getIs_recommended() {
        return is_recommended;
    }

    public void setIs_recommended(Boolean is_recommended) {
        this.is_recommended = is_recommended;
    }

}
