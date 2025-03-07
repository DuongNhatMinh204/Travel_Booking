package com.java.web_travel.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class OrderHotelDTO {
    @NotNull(message = "ARGUMENT_NOT_VALID")
    private Date startHotel ;
    @NotNull(message = "ARGUMENT_NOT_VALID")
    private Date endHotel ;
}
