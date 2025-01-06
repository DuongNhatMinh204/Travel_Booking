package com.java.web_travel.service;

import com.java.web_travel.entity.Booking;
import com.java.web_travel.model.BookingRequest;
import com.java.web_travel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public void createBooking(BookingRequest bookingRequest){
        Booking booking = new Booking();
        booking.setPalaceName(bookingRequest.getPalaceName());
        booking.setNumberOfPeople(bookingRequest.getNumberOfPeople());
        booking.setCheckinTime(bookingRequest.getCheckinTime());
        booking.setCheckoutTime(bookingRequest.getCheckoutTime());
        booking.setHotel(bookingRequest.getHotel());
        bookingRepository.save(booking);
    }
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public void cancelBooking(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            bookingRepository.delete(booking.get());
        }else {
            System.out.println("Booking not found");
        }
    }
}
