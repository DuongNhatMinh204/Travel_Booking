package com.java.web_travel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long id ;
    private String departure;
    private LocalDate flightDate ;
    private String classFlight ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getClassFlight() {
        return classFlight;
    }

    public void setClassFlight(String classFlight) {
        this.classFlight = classFlight;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }
}
