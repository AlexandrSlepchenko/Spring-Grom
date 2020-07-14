package com.Lesson2.HW1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    Route route;

    @Autowired
    Step step;

    @Autowired
    Service service;

    @RequestMapping(method = RequestMethod.GET, value = "/HW1Save", produces = "text/plain")
    public @ResponseBody
    String test() {
        return "123";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/HW1", produces = "text/plain")
    public @ResponseBody
    String callByBean(){
        route.getId();
        route.getSteps();

        step.getId();
        step.getParamServiceFrom();
        step.getParamServiceTo();
        step.getServiceFrom();
        step.getServiceTo();

        service.getId();
        service.getName();
        service.getParamsToCall();

        System.out.println("rout is OK");

        return null;
    }
}
