package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.Storage;
import com.Lesson3.HW.Utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StorageDAO extends GeneralRepository<Storage> {
    @Autowired
    public StorageDAO(Util util) {
        super(util);
        setClass(Storage.class);
    }
}
