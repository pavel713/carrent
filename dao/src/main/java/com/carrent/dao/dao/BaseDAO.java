package com.carrent.dao.dao;

import com.carrent.dao.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T extends BaseEntity> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();

    T findById (Class<T> tClass, Serializable id);


}
