//package com.Lesson3.HW.DAO;
//
//import com.MainDAO;
//
//@org.springframework.stereotype.Repository
//public class GeneralRepositoryImpl<T> extends MainDAO implements GeneralRepository<T> {
//    private Class tClass;
//
//    public void setClass(Class tClass) {
//        this.tClass = tClass;
//    }
//
//    public Class<T> getMyType() {
//        return this.tClass;
//    }
//
//    @Override
//    public T save(T t) {
//        entityManager.persist(t);
//        return t;
//    }
//
//    @Override
//    public T update(T t) {
//        entityManager.merge(t);
//        return t;
//    }
//
//    @Override
//    public void delete(long id) {
//        entityManager.remove(findById(id));
//    }
//
//    @Override
//    public T findById(long id) {
//        return entityManager.find(getMyType(), id);
//    }
//}
