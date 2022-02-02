package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;

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

    @Embedded
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name = "BILLING_STREET")),
            @AttributeOverride(name="city", column=@Column(name = "BILLING_CITY")),
            @AttributeOverride(name="zipcode", column=@Column(name = "BILLING_ZIPCODE"))
    })
    @Embedded
    private Address billingAddress;

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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", billingAddress='" + billingAddress +
                '}';
    }
}
