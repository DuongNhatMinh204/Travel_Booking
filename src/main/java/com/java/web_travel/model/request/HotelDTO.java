package com.java.web_travel.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class HotelDTO {
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String hotelName;
   @NotNull(message ="ARGUMENT_NOT_VALID" )
   private double price;
}
