package com.socketapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    DeviceRepo deviceRepo;

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public String home (ModelMap model){

        ArrayList<Device> testClasses = deviceRepo.findAll();

        model.addAttribute("arr", testClasses);

        return "home";
    }
}
