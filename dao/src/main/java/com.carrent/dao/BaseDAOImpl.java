package com.carrent.dao;


import com.carrent.entities.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public BaseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(final T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().update(entity);
    }

    @Override
    public T findById(Class<T> tClass, Serializable id) {
        return (T) getSession().get(tClass, id);
    }

    @Override
    public List<T> findAll() {
     return null;

    }

}



