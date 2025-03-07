package com.java.web_travel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hotels")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_price")
    private double hotelPrice;

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;


//    public Hotel() {}

    public Hotel(String hotelName, double hotelPrice) {
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
    }

}