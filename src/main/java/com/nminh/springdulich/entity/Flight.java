package com.nminh.springdulich.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nminh.springdulich.enums.TicketClass;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "ticket_class")
    @Enumerated(EnumType.STRING)
    private TicketClass ticketClass;
    @Column(name = "airline_name")
    private String airlineName ;
    @Column(name = "price")
    private double price;
    @Column(name = "check_in_date")
    @DateTimeFormat
    private Date checkInDate ;
    @Column(name = "check_out_date")
    @DateTimeFormat
    private Date checkOutDate ;
    @Column(name = "numberOfChairs")
    private int numberOfChairs ;
    @Column(name = "seatAvailable")
    private int seatAvailable ;

    @OneToMany(mappedBy = "flight" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders ;

    public Flight() {
    }

    public Flight(Long id, TicketClass ticketClass, String airlineName, double price, Date checkInDate, Date checkOutDate, int numberOfChairs) {
        this.id = id;
        this.ticketClass = ticketClass;
        this.airlineName = airlineName;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfChairs = numberOfChairs;
        this.seatAvailable = numberOfChairs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfChairs() {
        return numberOfChairs;
    }

    public void setNumberOfChairs(int numberOfChairs) {
        this.numberOfChairs = numberOfChairs;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }
}
