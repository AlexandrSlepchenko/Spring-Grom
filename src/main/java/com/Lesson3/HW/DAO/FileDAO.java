package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Model.Storage;
import com.Lesson3.HW.utils.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileDAO extends GeneralRepository<File> {
    public FileDAO(Util util) {
        super(util);
    }

    public File put(Storage storage, File file) {
        file.setStorage(storage);
        return update(file);
    }

    public void delete(Storage storage, File file) {
        if (file.getStorage() != null && file.getStorage().equals(storage)) {
            delete(file.getId());
        }
    }

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
