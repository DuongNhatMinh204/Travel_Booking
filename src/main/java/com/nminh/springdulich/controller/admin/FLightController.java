package com.nminh.springdulich.controller.admin;

import com.nminh.springdulich.entity.Flight;
import com.nminh.springdulich.model.request.FlightDTO;
import com.nminh.springdulich.model.response.ApiReponse;
import com.nminh.springdulich.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FLightController {
    @Autowired
    private FlightService flightService;
    @PostMapping("/create")
    public ApiReponse<Flight> createFlight(@Valid @RequestBody FlightDTO flightDTO) {
        ApiReponse<Flight> apiReponse = new ApiReponse<>();
        Flight flight = flightService.createFlight(flightDTO);
        apiReponse.setData(flight);
        apiReponse.setMessage("Flight created");
        return apiReponse;
    }
    @DeleteMapping("/delete/{id}")
    public ApiReponse<Flight> deleteFlight(@PathVariable Long id) {
        ApiReponse<Flight> apiReponse = new ApiReponse<>();
        flightService.deleteFlight(id);
        apiReponse.setMessage("Flight deleted");
        return apiReponse;
    }
    @PatchMapping("/update/{id}")
    public ApiReponse<Flight> updateFlight(@PathVariable Long id,@Valid @RequestBody FlightDTO flightDTO) {
        ApiReponse<Flight> apiReponse = new ApiReponse<>();
        apiReponse.setData(flightService.updateFlight(id, flightDTO));
        apiReponse.setMessage("Flight updated");
        return apiReponse;
    }
    @GetMapping("/getAll")
    public ApiReponse<List<Flight>> getAllFlights() {
        ApiReponse<List<Flight>> apiReponse = new ApiReponse<>();
        apiReponse.setData(flightService.getAllFlights());
        apiReponse.setMessage("success");
        return apiReponse;
    }
}
