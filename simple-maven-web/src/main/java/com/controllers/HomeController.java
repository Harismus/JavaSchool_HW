package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping(value = {"", "index"})
    public ModelAndView getIndex(){
        System.out.println("HomeController.getIndex");
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping("/welcome")
    public String getWelcome(){
        System.out.println("HomeController.getWelcome");
        return "welcome";
    }
}
