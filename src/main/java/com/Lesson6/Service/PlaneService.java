package com.Lesson6.Service;

import com.Lesson6.DAO.Impl.PlaneDAOImpl;
import com.Lesson6.Model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {
    PlaneDAOImpl planeDAO;

    @Autowired
    public PlaneService(PlaneDAOImpl planeDAO) {
        this.planeDAO = planeDAO;
    }

    public Plane savePlane(Plane plane) {
        return planeDAO.save(plane);
    }

    public Plane updatePlane(Plane plane) {
        return planeDAO.update(plane);
    }

    public void deletePlane(Long id) {
        planeDAO.delete(id);
    }

    public Plane findPlaneById(Long id) {
        return planeDAO.findById(id);
    }
}
