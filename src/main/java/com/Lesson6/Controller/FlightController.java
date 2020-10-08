package com.Lesson6.Controller;

import com.Lesson6.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FlightController {
    FlightService flightService;

    @Autowired
    private FlightController(FlightService flightService){
        this.flightService = flightService;
    }
}
