package com.java.web_travel.controller.user;

import com.java.web_travel.dto.request.UserRequest;
import com.java.web_travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserLoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String showLoginForm(Model model) {
        UserRequest userRequest = new UserRequest();
        model.addAttribute("userRequest", userRequest);
        return "user";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("userRequest") UserRequest userRequest ) {
        boolean validated = userService.validateUser(userRequest.getTelephone(), userRequest.getPassword());
        if (validated) {
            return "home";
        }
        else {
            return "redirect:/login";
        }
    }
}
