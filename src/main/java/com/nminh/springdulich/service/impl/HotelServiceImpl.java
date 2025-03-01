package com.nminh.springdulich.service.impl;

import com.nminh.springdulich.entity.Hotel;
import com.nminh.springdulich.enums.ErrorCode;
import com.nminh.springdulich.exception.AppException;
import com.nminh.springdulich.model.request.HotelDTO;
import com.nminh.springdulich.repository.HotelRepository;
import com.nminh.springdulich.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setHotelPrice(hotelDTO.getPrice());
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new AppException(ErrorCode.HOTEL_NOT_FOUND));
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }
}
