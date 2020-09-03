package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Model.Storage;
import com.MainDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class FileDAO extends MainDAO {

//    public FileDAO() {
//        setClass(File.class);
//    }

    public File save(File file) {
        entityManager.persist(file);
        return file;
    }

    public File update(File file) {
        entityManager.merge(file);
        return file;
    }

    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

    public File findById(Long id) {
        return entityManager.find(File.class, id);
    }

    public List getAllItems() {
        Query query = entityManager.createQuery("SELECT f FROM File f", File.class);
        return query.getResultList();
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
        Query query = entityManager.createQuery("SELECT fi FROM File fi WHERE fi.storage =:storage");
        return query.setParameter("storage", storage).getResultList();
    }
}
