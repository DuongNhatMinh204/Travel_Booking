package com.java.web_travel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue
    private Long id ;
    @Column(name = "palaceName")
    private String palaceName ;
    @Column(name = "numberOfPeople")
    private int numberOfPeople ;
    @Column(name = "checkinTime")
    private LocalDate checkinTime ;
    @Column(name = "checkoutTime")
    private LocalDate checkoutTime ;
    @Column(name = "hotel")
    private String hotel ;

}
