package com.codeup.sittergitter.models;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="available_times")
public class AvailableTime {
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date end;

    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private User babysitter;

    public AvailableTime() {}

    public AvailableTime(Date start, Date end, User babysitter) {
        this.start = start;
        this.end = end;
        this.babysitter = babysitter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public User getBabysitter() {
        return babysitter;
    }

    public void setBabysitter(User user) {
        this.babysitter = user;
    }
}
