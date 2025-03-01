package com.nminh.springdulich.service;

import com.nminh.springdulich.entity.Flight;
import com.nminh.springdulich.model.request.FlightDTO;

import java.util.List;

public interface FlightService {
    public Flight createFlight(FlightDTO flightDTO);
    public void deleteFlight(Long id);
    public Flight updateFlight(Long id,FlightDTO flightDTO);
    public List<Flight> getAllFlights();
}
