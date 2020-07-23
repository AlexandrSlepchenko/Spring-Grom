package com.Lesson3.HW.DAO;

import com.Lesson3.HW.utils.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GeneralRepository<T> implements REPO<T>{

    private Class<T> clazz;

    public void setClass(Class<T> t) {
        this.clazz = t;
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
            session.delete(session.get(clazz, id));
            tr.commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public T findById(long id) {
        try (Session session = Util.createSessionFactory().openSession()) {

            return session.get(clazz, id);

        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}