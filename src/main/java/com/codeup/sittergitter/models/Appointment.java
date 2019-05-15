package com.codeup.sittergitter.models;


import javax.persistence.*;

@Entity
@Table(name="appointments")
public class Appointment {
    @Id @GeneratedValue
    private Long id;
    @Column
    private String start;
    @Column
    private String end;
    @Column
    private Boolean sitter_approved;
    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private User babysitter;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private User parent;

    public Appointment() {
    }

    public Appointment(String start, String end, Boolean sitter_approved, User babysitter, User parent) {
        this.start = start;
        this.end = end;
        this.sitter_approved = sitter_approved;
        this.babysitter = babysitter;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Boolean getSitter_approved() {
        return sitter_approved;
    }

    public void setSitter_approved(Boolean sitter_approved) {
        this.sitter_approved = sitter_approved;
    }

    public User getBabysitter() {
        return babysitter;
    }

    public void setBabysitter(User babysitter) {
        this.babysitter = babysitter;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }
}
