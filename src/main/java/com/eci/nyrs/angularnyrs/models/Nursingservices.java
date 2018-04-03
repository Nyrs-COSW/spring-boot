package com.eci.nyrs.angularnyrs.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Nursing_Services" )
public class Nursingservices {

    private String name;
    private String description;
    private String image;
    private List<Nurse> nurseList;



    public Nursingservices(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Nursingservices() {

    }

    @Id
    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @ManyToMany(mappedBy="services",fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Nurse> getNurseList() {
        return nurseList;
    }

    public void setNurseList(List<Nurse> nurseList) {
        this.nurseList = nurseList;
    }
}
