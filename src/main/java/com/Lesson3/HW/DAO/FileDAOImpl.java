package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Model.Storage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class FileDAOImpl extends GeneralRepository<File> implements FileDAO {

    public FileDAOImpl() {
        setClass(File.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

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
        return entityManager.createNativeQuery("SELECT * FROM FILES WHERE STORAGE =storage", File.class).
                setParameter("STORAGE", "storage").getResultList();
    }
}
