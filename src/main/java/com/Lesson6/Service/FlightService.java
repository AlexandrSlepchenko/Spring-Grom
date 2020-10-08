package com.Lesson6.Service;

import com.Lesson6.DAO.Impl.FlightDAOImpl;
import com.Lesson6.Model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    FlightDAOImpl flightDAO;

    @Autowired
    public FlightService (FlightDAOImpl flightDAO){
        this.flightDAO = flightDAO;
    }

    public Flight saveFlight(Flight flight){
        return flightDAO.save(flight);
    }

    public Flight updateFlight(Flight flight){
        return flightDAO.update(flight);
    }

    public void deleteFlight(Long id){
        flightDAO.delete(id);
    }

    public Flight findFlightById(Long id){
        return flightDAO.findById(id);
    }
}
