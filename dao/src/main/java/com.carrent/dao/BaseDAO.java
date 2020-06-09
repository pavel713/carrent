package com.carrent.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T findAll(Class<T> clazz, Serializable id);


}
