package com.java.web_travel.controller.admin;

import com.java.web_travel.entity.Hotel;
import com.java.web_travel.model.request.HotelDTO;
import com.java.web_travel.model.response.ApiReponse;
import com.java.web_travel.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PutMapping("/updateHotel/{id}")
    public  ApiReponse<Hotel> updateHotel(@Valid @RequestBody HotelDTO hotelDTO,@PathVariable Long id) {
        ApiReponse<Hotel> apiReponse = new ApiReponse<>();
        apiReponse.setData(hotelService.updateHotel(hotelDTO,id));
        return apiReponse;
    }
}
