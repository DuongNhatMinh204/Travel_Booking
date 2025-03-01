package com.nminh.springdulich.controller.admin;

import com.nminh.springdulich.entity.Hotel;
import com.nminh.springdulich.model.request.HotelDTO;
import com.nminh.springdulich.model.response.ApiReponse;
import com.nminh.springdulich.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/createHotel")
    public ApiReponse<Hotel> createHotel(@Valid @RequestBody HotelDTO hotelDTO) {
        ApiReponse<Hotel> apiReponse = new ApiReponse<>();
        apiReponse.setData(hotelService.createHotel(hotelDTO));
        return apiReponse;
    }
    @GetMapping("/getAllHotels")
    public ApiReponse<List<Hotel>> getAllHotels() {
        ApiReponse<List<Hotel>> apiReponse = new ApiReponse<>();
        apiReponse.setData(hotelService.getAllHotels());
        apiReponse.setMessage("Success");
        return apiReponse;
    }
}
