package com.java.web_travel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequest {
    private String departure;
    private LocalDate flightDate ;
    private String classFlight ;

}
