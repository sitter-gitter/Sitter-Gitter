package com.codeup.sittergitter.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name="available_times")
public class AvailableTime {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Timestamp start;

    @Column
    private Timestamp end;

    @Column
    @Type(type = "numeric_boolean")
    private Boolean isTaken;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column
//    private Date start;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column
//    private Date end;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "availableTime")
    @OneToOne(mappedBy = "availableTime")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private User babysitter;

    public AvailableTime() {}

    public AvailableTime(Timestamp start, Timestamp end, Boolean isTaken, Appointment appointment, User babysitter) {
        this.start = start;
        this.end = end;
        this.isTaken = isTaken;
        this.appointment = appointment;
        this.babysitter = babysitter;
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

    public Boolean getIsTaken() { return isTaken; }

    public void setIsTaken(Boolean isTaken) { this.isTaken = isTaken; }

    public Appointment getAppointment() { return appointment; }

    public void setAppointment(Appointment appointment) { this.appointment = appointment; }

    public User getBabysitter() {
        return babysitter;
    }

    public void setBabysitter(User user) {
        this.babysitter = user;
    }
}
