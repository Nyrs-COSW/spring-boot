package com.eci.nyrs.angularnyrs.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Nurse" )
public class Nurse{

    private List<Nursingservices> services;
    private int age;
    private String experience;
    private int years;
    private String role = "nurse";
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String username;

    public Nurse(String email, String password, String firstname, String lastname, String username, List<Nursingservices> services, int age, String experience, int years, String role, String email1, String password1, String firstname1, String lastname1, String username1) {
        this.services = services;
        this.age = age;
        this.experience = experience;
        this.years = years;
        this.role = role;
        this.email = email1;
        this.password = password1;
        this.firstname = firstname1;
        this.lastname = lastname1;
        this.username = username1;
    }

    public Nurse(List<Nursingservices> services, int age, String experience, int years, String role, String email, String password, String firstname, String lastname, String username) {
        this.services = services;
        this.age = age;
        this.experience = experience;
        this.years = years;
        this.role = role;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }

    public Nurse(int age, String experience, int years, String role, String email, String password, String firstname, String lastname, String username) {
        this.age = age;
        this.experience = experience;
        this.years = years;
        this.role = role;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }

    public Nurse(String email, String password, String firstname, String lastname, String username) {

        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }

    public Nurse (String email, String password, String firstname, String lastname, String username, int age, String experience, int years) {

        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.age=age;
        this.experience=experience;
        this.years=years;


    }

    public Nurse (String email, String password, String firstname, String lastname, String username, int age, String experience, int years,  ArrayList<Nursingservices> services ) {

        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.age=age;
        this.experience=experience;
        this.years=years;
        this.services = services;
    }

    public Nurse(){}

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

    @Column(name = "role", nullable = true)
    public String getRole() {
        return role;
    }

    @Column(name = "experience", nullable = true)
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Column(name = "age", nullable = true)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "years", nullable = true)
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Nurse_NursingServices",
            joinColumns =
            @JoinColumn(name="nurseUsername", referencedColumnName="username"),
            inverseJoinColumns =
            @JoinColumn(name="serviceName", referencedColumnName="name")
    )
    public List<Nursingservices> getServices() {
        return services;
    }

    public void setServices(List<Nursingservices> services) {
        this.services = services;
    }
}
