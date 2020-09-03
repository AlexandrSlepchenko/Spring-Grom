package com;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MainDAO {

    @PersistenceContext
    public EntityManager entityManager;
}
