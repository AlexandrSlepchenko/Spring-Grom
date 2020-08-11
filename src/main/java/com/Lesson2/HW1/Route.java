package com.Lesson2.HW1;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Route {
    private String id;
    private List steps;

    public Route(String id, List steps) {
        this.id = id;
        this.steps = steps;
    }

    public Route() {
    }

    public String getId() {
        return id;
    }

    public List getSteps() {
        return steps;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSteps(List steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", steps=" + steps +
                '}';
    }
}
