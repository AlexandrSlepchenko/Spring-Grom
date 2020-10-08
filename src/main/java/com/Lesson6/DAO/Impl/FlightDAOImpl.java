package com.Lesson6.DAO.Impl;

import com.Lesson6.Model.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class FlightDAOImpl extends GeneralDAOImpl<Flight>{
    public FlightDAOImpl(){
        setClass(Flight.class);
    }

//    SELECT CITY_FROM, cnt
//    FROM (SELECT CITY_FROM, COUNT(ID) AS cnt
//    FROM FLIGHT
//    GROUP BY CITY_FROM
//    ORDER BY COUNT(ID) DESC)
//    WHERE ROWNUM <=10

    private static final String SELECT_MOST_POPULAR_FROM = "SELECT cityFrom ,cnt FROM (SELECT cityFrom, COUNT(id) AS cnt FROM Flight GROUP BY cityFrom ORDER BY COUNT (id) DESC) WHERE ROWNUM <=10";
    private static final String SELECT_MOST_POPULAR_TO = "SELECT cityTo ,cnt FROM (SELECT cityTo, COUNT(id) AS cnt FROM Flight GROUP BY cityTo ORDER BY COUNT (id) DESC) WHERE ROWNUM <=10";


    public List mostPopularTo() {
        Query query = entityManager.createNativeQuery(SELECT_MOST_POPULAR_TO, Flight.class);
        return query.getResultList();
    }

    public List mostPopularFrom() {
        Query query = entityManager.createNativeQuery(SELECT_MOST_POPULAR_FROM, Flight.class);
        return query.getResultList();
    }






}
