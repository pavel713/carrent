package com.carrent.dao;

import com.carrent.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

@Repository
public class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    @Autowired
    public BaseDAOImpl() {
        this.entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDAOImpl.class);
    }

    @Override
    public void save(final T entity)
    {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(entity);

        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void update(T entity) {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(entity);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void delete(T entity) {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(entity);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void getById(Class<T> entity, Serializable id) {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();





    }

    @Override
    public List<T> findAll() {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();

        final List<T> result = session
                .createQuery("select e from " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
        session.getTransaction().commit();
        session.close();

        return result;
    }
}
