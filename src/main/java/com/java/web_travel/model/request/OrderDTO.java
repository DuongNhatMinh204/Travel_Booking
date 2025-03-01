package com.java.web_travel.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class OrderDTO {
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String destination ;
    @NotNull(message = "ARGUMENT_NOT_VALID")
    @Min(value = 1,message = "NUMBER_NOT_VALID")
    private Integer numberOfPeople ;
    @NotNull(message = "ARGUMENT_NOT_VALID")
    private Date checkInDate ;
    @NotNull(message = "ARGUMENT_NOT_VALID")
    private Date checkOutDate ;

    public OrderDTO() {
    }

    public OrderDTO(String destination, Integer numberOfPeople, Date checkInDate, Date checkOutDate) {
        this.destination = destination;
        this.numberOfPeople = numberOfPeople;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
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
}
