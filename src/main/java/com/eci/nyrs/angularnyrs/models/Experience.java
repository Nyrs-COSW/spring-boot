package com.eci.nyrs.angularnyrs.models;

import javax.persistence.*;

@Entity
@Table(name = "Experience" )
public class Experience {



    private int id;
    public User user;


    public Experience(User user) {
        this.user = user;
    }
    public Experience(){

    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_name")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
