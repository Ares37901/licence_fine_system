package com.portal.tvlicence.web;


//import jakarta.persistence.Column;
//import jakarta.validation.constraints.Pattern;

public class FineAmountDTO {

    //private int id;
    private String reference;
    private String house;
    private String street;
    private String city;
    private String postcode;
    private double fine;
    private String firstName;
    private String lastName;
    private String email;


    // Default constructor is needed for JSON parsing
    public FineAmountDTO() {
    }

    // Getter and setter methods

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

    public double getFine() {
        return fine;
    }
    public void setFine(double amount) {
        this.fine = amount;
    }
}

