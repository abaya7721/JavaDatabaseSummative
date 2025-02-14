package com.assessment.bistro.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Server implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serverId;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private LocalDate hireDate;
    @Temporal(TemporalType.DATE)
    private LocalDate termDate;

    public Server() {
    }

    public Server(int serverId, String firstName, String lastName, LocalDate hireDate, LocalDate termDate) {
        this.serverId = serverId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.termDate = termDate;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTermDate() {
        return termDate;
    }

    public void setTermDate(LocalDate termDate) {
        this.termDate = termDate;
    }

    @Override
    public String toString() {
        return "Server{" +
                "serverId=" + serverId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hireDate=" + hireDate +
                ", termDate=" + termDate +
                '}';
    }
}

