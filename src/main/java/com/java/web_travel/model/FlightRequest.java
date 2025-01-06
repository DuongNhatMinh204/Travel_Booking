package com.java.web_travel.model;

import java.time.LocalDate;
import java.util.Date;

public class FlightRequest {
    private String departure;
    private LocalDate flightDate ;
    private String classFlight ;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public String getClassFlight() {
        return classFlight;
    }

    public void setClassFlight(String classFlight) {
        this.classFlight = classFlight;
    }
}
