package com.portal.tvlicence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="licence_fine")
public class Licence {

    // Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="reference")
    private String reference;

    @Column(name="house")
    private String house;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="postcode")
    private String postcode;

    @Column(name="fine")
    private double fine;

    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    // Define constructors
    Licence() {

    }

    public Licence(String reference,String house, String street, String city, String postcode, double fine, String firstName, String lastName, String email) {

        this.reference = reference;
        this.house = house;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.fine = fine;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Licence{" +
                "LicenceID=" + id + '\'' +
                "Reference=" + reference + '\'' +
                "House=" + house + ", " +
                "Street=" + street + '\'' +
                "City=" + city + '\'' +
                "Postcode=" + postcode + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", Email='" + email + '\'' +
                "Fine=" + fine +
                '}';
    }
}
