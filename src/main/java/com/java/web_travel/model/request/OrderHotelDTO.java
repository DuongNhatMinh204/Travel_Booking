package com.java.web_travel.model.request;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class OrderHotelDTO {
    @NotNull(message = "ARGUMENT_NOT_VALID")
    private Date startHotel ;
    @NotNull(message = "ARGUMENT_NOT_VALID")
    private Date endHotel ;

    public OrderHotelDTO() {
    }

    public OrderHotelDTO(Date startHotel, Date endHotel) {
        this.startHotel = startHotel;
        this.endHotel = endHotel;
    }

    public Date getStartHotel() {
        return startHotel;
    }

    public void setStartHotel(Date startHotel) {
        this.startHotel = startHotel;
    }

    public Date getEndHotel() {
        return endHotel;
    }

    public void setEndHotel(Date endHotel) {
        this.endHotel = endHotel;
    }
}
