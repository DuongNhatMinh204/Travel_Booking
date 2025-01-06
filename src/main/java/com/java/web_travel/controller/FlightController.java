package com.java.web_travel.controller;

import com.java.web_travel.model.FlightRequest;
import com.java.web_travel.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/select")
    public ModelAndView selectFlight(@ModelAttribute FlightRequest flightRequest) {
        flightService.saveFlight(flightRequest);
        return new ModelAndView("redirect:/plan-trip");
    }
}