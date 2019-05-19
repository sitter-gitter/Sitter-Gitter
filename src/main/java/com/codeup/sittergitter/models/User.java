package com.codeup.sittergitter.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String streetAddr;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipCode;

    @Column
    @Type(type = "numeric_boolean")
    private Boolean isBabysitter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Child> children;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "babysitter")
    private List<Specification> specifications;

    public User() {
    }

  
    public User(String username, String password, String email, String firstName, String lastName, String streetAddr,
                String city, String state, String zipCode, Boolean isBabysitter, List<Review> reviews, List<Child> children, List<Specification> specifications) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddr = streetAddr;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.isBabysitter = isBabysitter;
        this.reviews = reviews;
        this.children = children;
        this.specifications = specifications;
    }

    public User(String username, String password, String email, String firstName, String lastName, String streetAddr,
                String city, String state, String zipCode, Boolean isBabysitter) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddr = streetAddr;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.isBabysitter = isBabysitter;
    }

    public User(String username, String password, String email, String firstName, String lastName, String streetAddr,
                String city, String state, String zipCode, Boolean isBabysitter, List<Review> reviews) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddr = streetAddr;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.isBabysitter = isBabysitter;
        this.reviews = reviews;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email, List<Review> reviews) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.reviews = reviews;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        firstName = copy.firstName;
        lastName = copy.lastName;
        streetAddr = copy.streetAddr;
        city = copy.city;
        state = copy.state;
        zipCode = copy.zipCode;
        isBabysitter = copy.isBabysitter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddr() {
        return streetAddr;
    }

    public void setStreetAddr(String streetAddr) {
        this.streetAddr = streetAddr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getisBabysitter() {
        return isBabysitter;
    }

    public void setIsBabysitter(Boolean isBabysitter) {
        this.isBabysitter = isBabysitter;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }
}


