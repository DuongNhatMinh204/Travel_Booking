package com.nminh.springdulich.model.request;

import com.nminh.springdulich.enums.TicketClass;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FlightDTO {
    @NotNull(message ="ARGUMENT_NOT_VALID" )
    private TicketClass ticketClass;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String airlineName ;
    @Min(value = 0 ,message = "NUMBER_NOT_VALID")
    private double price;
    @NotNull(message = "ARGUMENT_NOT_VALID")
    @DateTimeFormat()
    private Date checkInDate ;
    @NotNull(message = "ARGUMENT_NOT_VALID")
    @DateTimeFormat()
    private Date checkOutDate ;
    @Min(0)
    private int numberOfChairs ;

    public FlightDTO() {
    }

    public FlightDTO(TicketClass ticketClass, String airlineName, double price, Date checkInDate, Date checkOutDate, int numberOfChairs) {
        this.ticketClass = ticketClass;
        this.airlineName = airlineName;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfChairs = numberOfChairs;
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
}
