package com.eci.nyrs.angularnyrs.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;


@Entity
@Table(name = "Request" )
public class Request {

    private Date date;
    private User nurse;
    private User patient;
    private Nursingservices nursingservices;
    private Boolean accepted;
    private String description;
    private int code;

    public Request(Date date, User nurse, User patient, Nursingservices nursingservices, Boolean accepted, int code, String description) {
        this.date = date;
        this.nurse = nurse;
        this.patient = patient;
        this.nursingservices = nursingservices;
        this.accepted = accepted;
        this.code = code;
        this.description = description;
    }

    public Request(){
    }

    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="nurse_username", referencedColumnName="username", nullable=true)
    public User getNurse() {
        return nurse;
    }

    public void setNurse(User nurse) {
        this.nurse = nurse;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="patient_username", referencedColumnName="username", nullable=true)
    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="nursingservice_name", referencedColumnName="name", nullable=true)
    public Nursingservices getNursingservices() {
        return nursingservices;
    }

    public void setNursingservices(Nursingservices nursingservices) {
        this.nursingservices = nursingservices;
    }

    @Column(name = "accepted", nullable = true)
    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}
