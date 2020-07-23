package com.Lesson3.HW.Service;

import java.util.List;

public interface Service<T,K> {
    T put(K k, T t);
    void delete(K k, T t);
    List transferAll(K k1, K k2);
    T transferFile(K k, long id);
}
