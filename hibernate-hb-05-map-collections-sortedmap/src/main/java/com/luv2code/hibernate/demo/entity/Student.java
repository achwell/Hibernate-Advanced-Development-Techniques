package com.luv2code.hibernate.demo.entity;

import org.hibernate.annotations.SortComparator;

import javax.persistence.*;

import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @CollectionTable(name = "image")
    @MapKeyColumn(name = "file_name")
    @Column(name = "image_name")
//    @OrderBy
    @SortComparator(ReverseStringComparator.class)
    private SortedMap<String, String> images = new TreeMap<>();

    // Reverse String
    public static class ReverseStringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

    public Student() { }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImages(SortedMap<String, String> images) {
        this.images = images;
    }

    public Map<String, String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email +
                '}';
    }
}
