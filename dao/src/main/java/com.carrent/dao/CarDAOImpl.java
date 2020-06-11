package com.carrent.dao;

import com.carrent.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarDAOImpl extends BaseDAOImpl implements CarDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CarDAOImpl(SessionFactory sessionFactory, SessionFactory sessionFactory1) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory1;
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
        Session session = this.sessionFactory.getCurrentSession();
        List<Car> carList = session.createQuery("from Car").list();
        return carList;
    }
}

