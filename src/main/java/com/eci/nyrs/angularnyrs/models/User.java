package com.eci.nyrs.angularnyrs.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User" )
public class User
{


    private int age;
    private List<Experience> experience;
    private String role = "";
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String username;
    private List<Nursingservices> services;
    public User()
    {
    }
    public User( int age, String email, String password, String firstname, String lastname, String username) {

        this.age = age;
        this.role = "pacient";
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }
    public User(int age, List<Experience> experience, String email, String password, String firstname, String lastname, String username) {

        this.age = age;
        this.experience = experience;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.role = "nurse";
    }





    @Column(name = "email", nullable = true)
    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    @Column(name = "password", nullable = true)
    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    @Column(name = "firstname", nullable = true)
    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = true)
    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    @Id
    @Column(name = "username",unique = true)
    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
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

    public void setRole(String role) {
        this.role = role;
    }


    @OneToMany(mappedBy="user",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
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