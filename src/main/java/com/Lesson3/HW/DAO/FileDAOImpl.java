package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FileDAOImpl extends GeneralRepository<File> implements FileDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public FileDAOImpl() {
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
        List<File> files = entityManager.createNativeQuery("SELECT * FROM FILES WHERE STORAGE =:storage", File.class).
                setParameter("storage", "STORAGE").getResultList();
        return files;


//        try (Session session = Util.createSessionFactory().openSession()) {
//
//            NativeQuery query = session.createNativeQuery("SELECT * FROM FILES WHERE STORAGE =:storage");
//
//            query.addEntity(File.class);
//            query.setParameter("storage", storage);
//
//            return query.list();
//
//        } catch (HibernateException e) {
//            System.err.println(e.getMessage());
//        }
//        return null;
    }
}
