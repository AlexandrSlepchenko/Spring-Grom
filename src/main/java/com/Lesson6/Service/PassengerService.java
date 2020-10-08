package com.Lesson6.Service;

import com.Lesson6.DAO.Impl.PassengerDAOImpl;
import com.Lesson6.Model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    PassengerDAOImpl passengerDAO;

    @Autowired
    public PassengerService (PassengerDAOImpl passengerDAO){
        this.passengerDAO = passengerDAO;
    }

    public Passenger savePassenger(Passenger passenger){
        return passengerDAO.save(passenger);
    }

    public Passenger updatePassenger(Passenger passenger){
        return passengerDAO.update(passenger);
    }

    public void deletePassenger(Long id){
        passengerDAO.delete(id);
    }

    public Passenger findPassengerById(Long id){
        return passengerDAO.findById(id);
    }
}
