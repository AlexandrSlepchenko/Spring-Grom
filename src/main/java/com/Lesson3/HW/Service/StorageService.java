package com.Lesson3.HW.Service;

import com.Lesson3.HW.DAO.StorageDAO;
import com.Lesson3.HW.Model.Storage;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class StorageService implements Service<Storage> {
    StorageDAO storageDAO;

    @Autowired
    public StorageService(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
    }

    public Storage save(Storage storage) {
        return storageDAO.save(storage);
    }

    public Storage update(Storage storage) {
        return storageDAO.update(storage);
    }

    public void deleteById(long id) {
        storageDAO.delete(id);
    }

    public Storage findById(long id) {
        return storageDAO.findById(id);
    }
}
