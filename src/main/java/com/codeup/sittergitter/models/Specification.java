package com.codeup.sittergitter.models;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.lang.String;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="specifications")
public class Specification {

    @Id
    @GeneratedValue
    private long id;

    @Column
    @Type(type = "numeric_boolean")
    private Boolean isSmoker;

    @Column
    @Type(type = "numeric_boolean")
    private Boolean hasCprTraining;

    @Column
    @Type(type = "numeric_boolean")
    private Boolean hasTransportation;

    @Column
    private Integer yearsOfExperience;

//    @Enumerated(EnumType.STRING)
//    @Column
//    private EducationLevel educationLevel;
//    EducationLevel e1 = EducationLevel.stillInHighSchool;
//    EducationLevel e2 = EducationLevel.highSchoolDegree;
//    EducationLevel e3 = EducationLevel.collegeDegree;

    @Column
    private String birthdate;

    @ManyToOne
    @JoinColumn(name = "babysitter_id")
    private User babysitter;

    public Specification() {}

    public Specification(Boolean isSmoker, Boolean hasCprTraining, Boolean hasTransportation, Integer yearsOfExperience, String birthdate, User babysitter) {
        this.isSmoker = isSmoker;
        this.hasCprTraining = hasCprTraining;
        this.hasTransportation = hasTransportation;
        this.yearsOfExperience = yearsOfExperience;
        this.birthdate = birthdate;
        this.babysitter = babysitter;
    }

    //    public Specification(Boolean isSmoker, Boolean hasCprTraining, Boolean hasTransportation, Integer yearsOfExperience,
//                         EducationLevel educationLevel, String birthdate, User user) {
//        this.isSmoker = isSmoker;
//        this.hasCprTraining = hasCprTraining;
//        this.hasTransportation = hasTransportation;
//        this.yearsOfExperience = yearsOfExperience;
//        this.educationLevel = educationLevel;
//        this.birthdate = birthdate;
//        this.babysitter = user;
//    }
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

    public Boolean getHasCprTraining() {
        return hasCprTraining;
    }

    public void setHasCprTraining(Boolean hasCprTraining) {
        this.hasCprTraining = hasCprTraining;
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

//    public EducationLevel getEducationLevel() {
//        return educationLevel;
//    }
//
//    public void setEducationLevel(EducationLevel educationLevel) {
//        this.educationLevel = educationLevel;
//    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

//    public int getAge() {
//        Date today = new Date();
//        Date birthday = birthdate;
//        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        int d1 = Integer.parseInt(formatter.format(birthday));
//        int d2 = Integer.parseInt(formatter.format(today));
//        return (d2 - d1) / 10000;
//    }

    public User getBabysitter() { return babysitter; }

    public void setBabysitter(User user) {
        this.babysitter = user;
    }
}