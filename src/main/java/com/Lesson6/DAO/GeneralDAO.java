package com.Lesson6.DAO;

public interface GeneralDAO<T> {

    T save(T t);
    T update(T t);
    void delete(long id);
    T findById(long id);

}
