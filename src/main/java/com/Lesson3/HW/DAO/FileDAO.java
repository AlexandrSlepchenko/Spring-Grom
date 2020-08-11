package com.Lesson3.HW.DAO;

import com.Lesson3.HW.Model.File;
import com.Lesson3.HW.Model.Storage;

import java.util.List;


public interface FileDAO {
    File put(Storage storage, File file);
    void delete(Storage storage, File file);
    List<File> getAllFilesFromStorage(Storage storage);
}
