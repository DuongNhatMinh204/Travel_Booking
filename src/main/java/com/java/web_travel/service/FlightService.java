package com.java.web_travel.service;

import com.java.web_travel.entity.Flight;
import com.java.web_travel.model.FlightRequest;
import com.java.web_travel.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void saveFlight(FlightRequest flightRequest) {
        Flight flight = new Flight();
        // Set fields for flight
        flight.setDeparture(flightRequest.getDeparture());
        flight.setFlightDate(flightRequest.getFlightDate());
        flight.setClassFlight(flightRequest.getClassFlight());
        flightRepository.save(flight) ;
    }
}