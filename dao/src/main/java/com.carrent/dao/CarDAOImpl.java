package com.carrent.dao;

import com.carrent.Car;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarDAOImpl extends BaseDAOImpl implements CarDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public CarDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public void update(Car car) {
        sessionFactory.getCurrentSession().update(car);

    }

    @Override
    public void delete(Car car) {
        sessionFactory.getCurrentSession().delete(car);

    }

    @Override
    public List<Car> findAll(int page, int perPage) {
        Criteria criteria = getSession().createCriteria(Car.class);
        criteria.setFirstResult(page);
        criteria.setMaxResults(perPage);
        return (List<Car>) criteria.list();


    }


}

