package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.Storage;
import com.Lesson3.HW.utils.Util;
import org.springframework.stereotype.Repository;

@Repository
public class StorageDAO extends GeneralRepository<Storage> {
    public StorageDAO(Util util) {
        super(util);
    }
}
