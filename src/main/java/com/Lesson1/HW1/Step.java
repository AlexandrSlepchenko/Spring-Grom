package com.Lesson1.HW1;

import org.springframework.stereotype.Service;

import java.util.Map;

public class Step {
    private Long id;
    private Service serviceFrom;
    private Service serviceTo;
    private Map paramServiceFrom;
    private Map paramServiceTo;

    public Step(Long id, Service serviceFrom, Service serviceTo, Map paramServiceFrom, Map paramServiceTo) {
        this.id = id;
        this.serviceFrom = serviceFrom;
        this.serviceTo = serviceTo;
        this.paramServiceFrom = paramServiceFrom;
        this.paramServiceTo = paramServiceTo;
    }

    public Step() {
    }

    public Long getId() {
        return id;
    }

    public Service getServiceFrom() {
        return serviceFrom;
    }

    public Service getServiceTo() {
        return serviceTo;
    }

    public Map getParamServiceFrom() {
        return paramServiceFrom;
    }

    public Map getParamServiceTo() {
        return paramServiceTo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceFrom(Service serviceFrom) {
        this.serviceFrom = serviceFrom;
    }

    public void setServiceTo(Service serviceTo) {
        this.serviceTo = serviceTo;
    }

    public void setParamServiceFrom(Map paramServiceFrom) {
        this.paramServiceFrom = paramServiceFrom;
    }

    public void setParamServiceTo(Map paramServiceTo) {
        this.paramServiceTo = paramServiceTo;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", serviceFrom=" + serviceFrom +
                ", serviceTo=" + serviceTo +
                ", paramServiceFrom=" + paramServiceFrom +
                ", paramServiceTo=" + paramServiceTo +
                '}';
    }
}
