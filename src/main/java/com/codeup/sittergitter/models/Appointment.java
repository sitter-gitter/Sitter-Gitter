package com.codeup.sittergitter.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Month;

@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Timestamp start;

    @Column
    private Timestamp end;

    @Column
    @Type(type = "numeric_boolean")
    private Boolean sitterApproved;

    @Column
    @Type(type = "numeric_boolean")
    private Boolean isReviewed;

    @OneToOne
    @JoinColumn(name = "available_time_id", unique = true)
    private AvailableTime availableTime;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "appointment")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private User babysitter;

    @ManyToOne
    @JoinColumn(name = "parent_id") // referencedColumnName="id"
    private User parent;

    public Appointment() {
    }

    public Appointment(Timestamp start, Timestamp end, Boolean sitterApproved, Boolean isReviewed, AvailableTime availableTime, Review review , User babysitter, User parent) {
        this.start = start;
        this.end = end;
        this.sitterApproved = sitterApproved;
        this.isReviewed = isReviewed;
        this.availableTime = availableTime;
        this.review = review;
        this.babysitter = babysitter;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public Boolean getSitterApproved() {
        return sitterApproved;
    }

    public void setSitterApproved(Boolean sitterApproved) {
        this.sitterApproved = sitterApproved;
    }

    public Boolean getReviewed() { return isReviewed; }

    public void setReviewed(Boolean reviewed) { isReviewed = reviewed; }

    public AvailableTime getAvailableTime() { return availableTime; }

    public void setAvailableTime(AvailableTime availableTime) { this.availableTime = availableTime; }

    public Review getReview() { return review; }

    public void setReview(Review review) { this.review = review; }

    public User getBabysitter() { return babysitter; }

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
