package com.codeup.sittergitter.models;

import javax.persistence.*;

// create constructors for each instance (for edit dont construct user, etc.)


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
    @JoinColumn (name = "author_id", referencedColumnName="id")
    private User author;

    // C in CRUD
    public Review() {
    }

    // R in CRUD
    public Review(Long id, String title, String body, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    // U in CRUD
    public Review(String title, String body, User author) {
        this.title = title;
        this.body = body;
        this.author = author;
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



    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

//    public boolean contains( String[] array, String key) {
//        return Arrays.asList(array).contains(key);
//    }

//    public static void main(String[] args) {
//        String[] search = new String[] {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
//
//        int[] nums = new int[] {6,7,8,9,0,1,2,3,9,8,8,5,4,3};
//
//        System.out.println(Arrays.toString(search));
//        System.out.println(Arrays.toString(nums) + " before sort.");
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums) + " after sort");
//
//        Review asdf = new Review("asdf", "ASdf");
//
//
//        boolean s1 = asdf.contains(search, "purple");
//        boolean s2 = asdf.contains(search, "violet");
//
//        System.out.println("" + s1 + s2);
//
//        boolean s3 = Arrays.asList(search).contains("blue");
//
//        System.out.println(s3);
//
//    }

}
