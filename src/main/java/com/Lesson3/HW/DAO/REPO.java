package com.Lesson3.HW.DAO;

public interface REPO<T> {

    T save(T t);
    T update(T t);
    void delete(long id);
    T findById(long id);

}
