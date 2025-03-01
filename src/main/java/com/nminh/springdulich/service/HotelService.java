package com.nminh.springdulich.service;

import com.nminh.springdulich.entity.Hotel;
import com.nminh.springdulich.model.request.HotelDTO;

import java.util.List;

public interface HotelService {
    public Hotel createHotel(HotelDTO hotelDTO);
    public Hotel getHotel(Long hotelId);
    public List<Hotel> getAllHotels();
}
