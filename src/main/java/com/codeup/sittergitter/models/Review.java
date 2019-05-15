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
//    @JoinColumns({
//        @JoinColumn(name = "author_id", referencedColumnName="id"),
//        @JoinColumn(name = "author_username", referencedColumnName="username")
//    })
    @JoinColumn (name = "parent_id", referencedColumnName="id")
    private User parent;

    @ManyToOne
    @JoinColumn (name = "babysitter_id", referencedColumnName = "id")
    private User babysitter;

    // C in CRUD
    public Review() {
    }

    // R in CRUD
    public Review(Long id, String title, String body, User parent, User babysitter) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.parent = parent;
        this.babysitter = babysitter;
    }

    // U in CRUD
    public Review(String title, String body, User parent, User babysitter) {
        this.title = title;
        this.body = body;
        this.parent = parent;
        this.babysitter = babysitter;
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

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public User getBabysitter() {
        return babysitter;
    }

    public void setBabysitter(User babysitter) {
        this.babysitter = babysitter;
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
