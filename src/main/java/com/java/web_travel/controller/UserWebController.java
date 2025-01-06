package com.java.web_travel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserWebController {
    @RequestMapping(value = "booking" , method = RequestMethod.GET)
    public ModelAndView booking() {
        ModelAndView mav = new ModelAndView("booking");
        return mav ;
    }
    @RequestMapping(value = "home" , method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav ;
    }
    @RequestMapping(value = "contact" , method = RequestMethod.GET)
    public ModelAndView contact() {
        ModelAndView mav = new ModelAndView("contact");
        return mav ;
    }
    @RequestMapping(value = "gallery" , method = RequestMethod.GET)
    public ModelAndView gallery() {
        ModelAndView mav = new ModelAndView("gallery");
        return mav ;
    }
    @RequestMapping(value = "news" , method = RequestMethod.GET)
    public ModelAndView news() {
        ModelAndView mav = new ModelAndView("news");
        return mav ;
    }
    @RequestMapping(value = "package" , method = RequestMethod.GET)
    public ModelAndView packages() {
        ModelAndView mav = new ModelAndView("package");
        return mav ;
    }
    @RequestMapping(value = "review" , method = RequestMethod.GET)
    public ModelAndView review() {
        ModelAndView mav = new ModelAndView("review");
        return mav ;
    }
    @RequestMapping(value = "services" , method = RequestMethod.GET)
    public ModelAndView services() {
        ModelAndView mav = new ModelAndView("services");
        return mav ;
    }
    @RequestMapping(value = "trending" , method = RequestMethod.GET)
    public ModelAndView trending() {
        ModelAndView mav = new ModelAndView("trending");
        return mav ;
    }
    @RequestMapping(value = "user" , method = RequestMethod.GET)
    public ModelAndView user() {
        ModelAndView mav = new ModelAndView("user");
        return mav ;
    }
    @RequestMapping(value = "plan-trip" , method = RequestMethod.GET)
    public ModelAndView planTrip() {
        ModelAndView mav = new ModelAndView("plan-trip");
        return mav ;
    }
    @RequestMapping(value = "flight" , method = RequestMethod.GET)
    public ModelAndView flight() {
        ModelAndView mav = new ModelAndView("flight");
        return mav ;
    }
}
