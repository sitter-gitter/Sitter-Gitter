package com.codeup.sittergitter.models;

import javax.persistence.*;
import java.lang.String;


@Entity
@Table(name="specifications")
public class Specification {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private Boolean isSmoker;

    @Column
    private Boolean hasCprTraining;

    @Column
    private Boolean hasTransportation;

    @Column
    private Integer yearsOfExperience;

    @Enumerated(EnumType.STRING)
    @Column
    private EducationLevel educationLevel;

    @Column
    private String birthdate;

    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private User babysitter;

    public Specification() {}

    public Specification(Boolean isSmoker, Boolean hasCPRTraining, Boolean hasTransportation, Integer yearsOfExperience, EducationLevel educationLevel, String birthdate, User user) {
        this.isSmoker = isSmoker;
        this.hasCprTraining = hasCPRTraining;
        this.hasTransportation = hasTransportation;
        this.yearsOfExperience = yearsOfExperience;
        this.educationLevel = educationLevel;
        this.birthdate = birthdate;
        this.babysitter = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getSmoker() {
        return isSmoker;
    }

    public void setSmoker(Boolean smoker) {
        isSmoker = smoker;
    }

    public Boolean getHasCPRTraining() {
        return hasCprTraining;
    }

    public void setHasCPRTraining(Boolean hasCPRTraining) {
        this.hasCprTraining = hasCPRTraining;
    }

    public Boolean getHasTransportation() {
        return hasTransportation;
    }

    public void setHasTransportation(Boolean hasTransportation) {
        this.hasTransportation = hasTransportation;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public User getBabysitter() {
        return babysitter;
    }

    public void setBabysitter(User user) {
        this.babysitter = user;
    }
}