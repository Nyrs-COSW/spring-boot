package com.eci.nyrs.angularnyrs.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users" )
public class User
{

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String username;

    public User()
    {
    }

    public User( String email, String password, String firstname, String lastname, String username )
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
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

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}