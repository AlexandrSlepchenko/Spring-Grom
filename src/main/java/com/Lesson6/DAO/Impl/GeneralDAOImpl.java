package com.Lesson6.DAO.Impl;

import com.Lesson6.DAO.GeneralDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class GeneralDAOImpl<T> implements GeneralDAO<T> {

    @PersistenceContext
    public EntityManager entityManager;

    private Class<T> tClass;

    public void setClass(Class<T> tClass) {
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
        entityManager.remove(findById(id));
    }

    @Override
    public T findById(long id) {
        return entityManager.find(getMyType(), id);
    }
}
