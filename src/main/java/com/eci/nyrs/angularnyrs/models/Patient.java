package com.eci.nyrs.angularnyrs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "Patient" )
public class Patient implements java.io.Serializable {

    private int age;
    private long creditCardNumber;
    private int creditCVV;
    private String role= "patient";
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String username;

    public Patient(){

    }

    public Patient(int age, long creditCardNumber, int creditCVV, String role, String email, String password, String firstname, String lastname, String username) {
        this.age = age;
        this.creditCardNumber = creditCardNumber;
        this.creditCVV = creditCVV;
        this.role = role;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }

    public Patient(String email, String password, String firstname, String lastname, String username, int age, long creditCardNumber, int creditCVV) {

        this.age=age;
        this.creditCardNumber=creditCardNumber;
        this.creditCVV=creditCVV;

    }

    public Patient(String email, String password, String firstname, String lastname, String username) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }

    @Column(name = "email", nullable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "firstname", nullable = true)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = true)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Id
    @Column(name = "username",unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "age", nullable = true)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "role", nullable = true)
    public String getRole() {
        return role;
    }

    public void setRole(String role) { this.role  = role;}

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Column(name = "creditCardNumer", nullable = true)
    public long getCreditCardNumber() {
        return creditCardNumber;
    }


    @Column(name = "creditCVV", nullable = true)
    public int getCreditCVV() {
        return creditCVV;
    }

    public void setCreditCVV(int creditCVV) {
        this.creditCVV = creditCVV;
    }
}
