package com.lvtinger.test.repository;

import com.lvtinger.value.PersistentObject;

import java.io.Serializable;

public interface Repository<E extends PersistentObject<K>, K extends Serializable> {
    boolean insert(E po);
    boolean update(E po);
    boolean delete(E po);
    E getById(K id);
}