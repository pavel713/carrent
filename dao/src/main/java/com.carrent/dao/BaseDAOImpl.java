package com.carrent.dao;


import com.carrent.entities.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public BaseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
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
    public T findAll(Class<T> clazz, Serializable id) {
        T t = (T) getSession().get(clazz, id);
        return t;
    }

}



