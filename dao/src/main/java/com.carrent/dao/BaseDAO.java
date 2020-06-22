package com.carrent.dao;

import com.carrent.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T extends BaseEntity> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();

    T findById (Class<T> tClass, Serializable id);


}
