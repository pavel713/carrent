package com.carrent.dao;

import com.carrent.Car;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
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
        sessionFactory.getCurrentSession().createQuery("update c from Car where c.id", Car.class);


    }

    @Override
    public void delete(Car car) {
        sessionFactory.getCurrentSession().delete(car);

    }

    @Override
    public List<Car> findAll() {
        return null;


    }


}

