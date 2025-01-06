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
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue
    private Long id ;
    @Column(name = "departure")
    private String departure;

    @Column(name = "flightDate")
    private LocalDate flightDate ;

    @Column(name = "classFlight")
    private String classFlight ;


}
