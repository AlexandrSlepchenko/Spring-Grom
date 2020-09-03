package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.Storage;
import com.MainDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class StorageDAO extends MainDAO {
//    public StorageDAO() {
//        setClass(Storage.class);
//    }

    public Storage save(Storage storage) {
        entityManager.persist(storage);
        return storage;
    }

    public Storage update(Storage storage) {
        entityManager.merge(storage);
        return storage;
    }

    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

    public Storage findById(Long id) {
        return entityManager.find(Storage.class, id);
    }

    public List getAllItems() {
        Query query = entityManager.createQuery("SELECT s FROM Storage s", Storage.class);
        return query.getResultList();
    }
}
