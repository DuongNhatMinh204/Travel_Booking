package com.java.web_travel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private String palaceName ;
    private int numberOfPeople ;
    private LocalDate checkinTime ;
    private LocalDate checkoutTime ;
    private String hotel ;


}
