package com.Lesson3.HW.DAO;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GeneralRepository<T> implements REPO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class tClass;

    public void setClass(Class tClass) {
        this.tClass = tClass;
    }

    public Class<T> getMyType() {
        return this.tClass;
    }

    @Override
    public T save(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    public void delete(long id) {
        entityManager.detach(findById(id));
    }

    @Override
    public T findById(long id) {
        return entityManager.find(getMyType(), id);
    }
}
