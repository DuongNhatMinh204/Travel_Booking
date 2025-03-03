package com.java.web_travel.controller;

import com.java.web_travel.dto.GetMethodResponse;
import com.java.web_travel.entity.UserEntity;
import com.java.web_travel.entity.UserProfileEntity;
import com.java.web_travel.model.UserModel;
import com.java.web_travel.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.service.invoker.HttpServiceProxyFactory.builder;

@RestController
@RequestMapping("/users")
@Tag(name = "user_profile")
@RequiredArgsConstructor
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    // API tạo mới User
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String email,
                                 @RequestParam String phone) {
         UserEntity user=userProfileService.createUser(username, password, email, phone);
         return ResponseEntity.ok(user);

    }
    @GetMapping("/profile")
    public String showProfile(@RequestParam("userId") Integer userId, Model model) {
        UserProfileEntity user = userProfileService.getUserById(userId);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "userProfile"; // Tên file HTML Thymeleaf
    }

    // API sửa UserProfile
    @PutMapping("/{userId}/profile")
    @Operation(summary = "API delete buddhist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully")
    })
    public String updateUserProfile(HttpServletRequest request,
                                    @PathVariable Integer userId,
                                    @RequestParam(required = false) String fullName,
                                    @RequestParam(required = false) String telephone,
                                    @RequestParam(required = false) String email,
                                    Model model) {
        UserProfileEntity userProfileEntity=userProfileService.updateProfile(userId, fullName, telephone, email);

        model.addAttribute("user", userProfileEntity.getUser());
        model.addAttribute("userProfile", userProfileEntity);

        // Gửi thông báo thành công
        model.addAttribute("successMessage", "Hồ sơ đã được cập nhật thành công!");
        return "userProfile";
//        return ResponseEntity.ok(userProfileEntity);
    }

    @GetMapping("/{id}")
    @Operation(summary = "API get user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully")
    })
    public ResponseEntity<?> getBuddhistById(@PathVariable Integer id) {
        UserModel userModel = userProfileService.findUserById(id);
        return ResponseEntity.ok(GetMethodResponse.builder()
                .status(true)
                .message("Successfully")
                .data(userModel)
                .errorCode(HttpStatus.OK.name().toLowerCase())
                .httpCode(HttpStatus.OK.value())
                .build()
        );
    }

}

