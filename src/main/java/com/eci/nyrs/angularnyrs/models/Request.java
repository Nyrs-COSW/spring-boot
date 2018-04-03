package com.eci.nyrs.angularnyrs.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;


@Entity
@Table(name = "Request" )
public class Request {

    private Date date;
    private Nurse nurse;
    private Patient patient;
    private Nursingservices nursingservices;
    private Boolean accepted;
    private String description;
    private int code;

    public Request(Date date, Nurse nurse, Patient patient, Nursingservices nursingservices, Boolean accepted, int code, String description) {
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
    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    @ManyToOne(cascade=ALL)
    @JoinColumn(name="patient_username", referencedColumnName="username", nullable=true)
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
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
