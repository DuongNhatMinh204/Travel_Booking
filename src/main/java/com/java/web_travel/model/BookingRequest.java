package com.java.web_travel.model;

import java.time.LocalDate;

public class BookingRequest {
    private String palaceName ;
    private int numberOfPeople ;
    private LocalDate checkinTime ;
    private LocalDate checkoutTime ;
    private String hotel ;

    public String getPalaceName() {
        return palaceName;
    }

    public void setPalaceName(String palaceName) {
        this.palaceName = palaceName;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public LocalDate getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(LocalDate checkinTime) {
        this.checkinTime = checkinTime;
    }

    public LocalDate getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDate checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}
