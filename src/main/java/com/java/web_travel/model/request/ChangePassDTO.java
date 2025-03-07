package com.java.web_travel.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChangePassDTO {
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String phone ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String password ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String newPassword ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String confirmPassword ;

}
