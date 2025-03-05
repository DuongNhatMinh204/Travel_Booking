package com.java.web_travel.service.impl;

import com.java.web_travel.entity.Hotel;
import com.java.web_travel.enums.ErrorCode;
import com.java.web_travel.exception.AppException;
import com.java.web_travel.model.request.HotelDTO;
import com.java.web_travel.repository.HotelRepository;
import com.java.web_travel.service.HotelService;
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
        if(hotelDTO.getPrice() <0){
            throw  new AppException(ErrorCode.PRICE_NOT_VALID);
        }
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

    @Override
    public Hotel updateHotel(HotelDTO hotelDTO , Long hotelId){
        if(hotelDTO.getPrice() <0){
            throw  new AppException(ErrorCode.PRICE_NOT_VALID);
        }
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new AppException(ErrorCode.HOTEL_NOT_FOUND));
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setHotelPrice(hotelDTO.getPrice());
        return hotelRepository.save(hotel);
    }
}
