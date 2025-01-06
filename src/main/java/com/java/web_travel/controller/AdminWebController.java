package com.java.web_travel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminWebController {
    @RequestMapping(value = "admin_booking" , method = RequestMethod.GET)
    public ModelAndView adminBooking(){
        ModelAndView mav = new ModelAndView("admin_booking");
        return mav ;
    }
    @RequestMapping(value = "admin_account" , method = RequestMethod.GET)
    public ModelAndView adminAccount(){
        ModelAndView mav = new ModelAndView("admin_account");
        return mav ;
    }
    @RequestMapping(value = "createStaff" , method = RequestMethod.GET)
    public ModelAndView createStaff(){
        ModelAndView mav = new ModelAndView("createStaff");
        return mav ;
    }
}
