package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Utils.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralRepository<T> implements REPO<T>{

    private Class tClass;

    public void setClass(Class tClass) {
        this.tClass = tClass;
    }

    public Class<T> getMyType() {
        return this.tClass;
    }

    Util util;

    @Autowired
    public GeneralRepository(Util util) {
        this.util = util;
    }

    @Override
    public T save(T t) {
        try (Session session = Util.createSessionFactory().openSession()) {
            Transaction tr = session.getTransaction();
            tr.begin();
            session.save(t);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return t;
    }

    @Override
    public T update(T t) {
        try (Session session = Util.createSessionFactory().openSession()) {
            Transaction tr = session.getTransaction();
            tr.begin();
            session.update(t);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return t;
    }

    @Override
    public void delete(long id) {

        try (Session session = Util.createSessionFactory().openSession()) {
            Transaction tr = session.getTransaction();
            tr.begin();
            session.delete(session.get(getMyType(), id));
            tr.commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public T findById(long id) {
        try (Session session = Util.createSessionFactory().openSession()) {

            return session.get(getMyType(), id);

        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
