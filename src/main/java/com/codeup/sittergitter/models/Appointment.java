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

    @OneToOne
    @JoinColumn(name = "available_time_id", unique = true)
    private AvailableTime availableTime;

    @OneToOne(mappedBy = "appointment")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private User babysitter;

    @ManyToOne
    @JoinColumn(name = "parent_id") // referencedColumnName="id"
    private User parent;

    public Appointment() {
    }

    public Appointment(Timestamp start, Timestamp end, Boolean sitterApproved, AvailableTime availableTime, User babysitter, User parent) {
        this.start = start;
        this.end = end;
        this.sitterApproved = sitterApproved;
        this.availableTime = availableTime;
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

    public AvailableTime getAvailableTime() { return availableTime; }

    public void setAvailableTime(AvailableTime availableTime) { this.availableTime = availableTime; }

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
