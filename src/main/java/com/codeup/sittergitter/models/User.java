package com.codeup.sittergitter.models;

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
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String street_addr;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipcode;

    @Column
    private boolean is_babysitter = false;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Child> children;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "babysitter")
    private List<Specification> specifications;

    public User() {
    }

    public User(String username, String password, String email, String first_name, String last_name, String street_addr, String city, String state, String zipcode, boolean is_babysitter, List<Review> reviews, List<Child> children, List<Specification> specifications) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street_addr = street_addr;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.is_babysitter = is_babysitter;
        this.reviews = reviews;
        this.children = children;
        this.specifications = specifications;
    }

    public User(String username, String password, String email, String first_name, String last_name, String street_addr, String city, String state, String zipcode, boolean is_babysitter) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street_addr = street_addr;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.is_babysitter = is_babysitter;
    }

    public User(String username, String password, String email, String first_name, String last_name, String street_addr, String city, String state, String zipcode, boolean is_babysitter, List<Review> reviews) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street_addr = street_addr;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.is_babysitter = is_babysitter;
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
        first_name = copy.first_name;
        last_name = copy.last_name;
        street_addr = copy.street_addr;
        city = copy.city;
        state = copy.state;
        zipcode = copy.zipcode;
        is_babysitter = copy.is_babysitter;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStreet_addr() {
        return street_addr;
    }

    public void setStreet_addr(String street_addr) {
        this.street_addr = street_addr;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isIs_babysitter() {
        return is_babysitter;
    }

    public void setIs_babysitter(boolean is_babysitter) {
        this.is_babysitter = is_babysitter;
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


