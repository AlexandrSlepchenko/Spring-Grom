package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Model.Storage;
import com.Lesson3.HW.Utils.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileDAOImpl extends GeneralRepository<File> implements FileDAO{
    Util util;

    @Autowired
    public FileDAOImpl(Util util) {
        super(util);
        setClass(File.class);
    }

    @Override
    public File put(Storage storage, File file) {
        file.setStorage(storage);
        return update(file);
    }

    @Override
    public void delete(Storage storage, File file) {
        if (file.getStorage() != null && file.getStorage().equals(storage)) {
            delete(file.getId());
        }
    }

    @Override
    public List<File> getAllFilesFromStorage(Storage storage) {
        try (Session session = Util.createSessionFactory().openSession()) {

            NativeQuery query = session.createNativeQuery("SELECT * FROM FILES WHERE STORAGE =:storage");

            query.addEntity(File.class);
            query.setParameter("storage", storage);

            return query.list();

        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}