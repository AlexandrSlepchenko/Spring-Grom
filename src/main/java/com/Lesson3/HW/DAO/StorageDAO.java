package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StorageDAO extends GeneralRepository<Storage> {
    @Autowired
    public StorageDAO() {
        setClass(Storage.class);
    }
}
