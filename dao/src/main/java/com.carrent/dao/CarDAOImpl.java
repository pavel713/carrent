package com.carrent.dao;

import com.carrent.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CarDAOImpl extends BaseDAOImpl implements CarDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CarDAOImpl(SessionFactory sessionFactory, SessionFactory session) {
        super(sessionFactory);
        this.sessionFactory = session;
    }

    @Override
    public void save(Car car) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(car);

    }

    @Override
    public void update(Car car) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(car);


    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Car book = (Car) session.load(Car.class, id);
        if (book != null) {
            session.delete(book);
        }

    }

    @Override
    public List<Car> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Car> carList = session.createQuery("from Car ").list();
        return carList;
    }
}

