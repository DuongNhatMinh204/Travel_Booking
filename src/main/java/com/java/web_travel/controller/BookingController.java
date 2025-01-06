package com.java.web_travel.controller;

import com.java.web_travel.entity.Booking;
import com.java.web_travel.model.BookingRequest;
import com.java.web_travel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ModelAndView createBooking(@ModelAttribute BookingRequest bookingRequest) {
        bookingService.createBooking(bookingRequest);
        return new ModelAndView("redirect:/flight");
    }
    @GetMapping("/details")
    public List<Booking> getBookingDetails() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking deleted");
    }

}
