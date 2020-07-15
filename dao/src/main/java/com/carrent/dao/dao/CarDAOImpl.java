package com.carrent.dao.dao;

import com.carrent.dao.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarDAOImpl extends BaseDAOImpl<Car> implements CarDAO<Car> {



    private SessionFactory sessionFactory;

    public CarDAOImpl(SessionFactory sessionFactory, SessionFactory sessionFactory1) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory1;
    }




    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Car car = (Car) session.load(Car.class, id);
        if(car!=null){
            session.delete(car);
        }

    }

    @Override
    public List<Car> listCars() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Car> carList = session.createQuery("from Car").list();

        return carList;
    }

    @Override
    public void save(Car car){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(car);
    }

    @Override
    public void update(Car car){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(car);
    }


    @Override
    public Car findById(Long id) {
        Session session =this.sessionFactory.getCurrentSession();
        Car car = (Car) session.load(Car.class, id);

        return car;
    }
}






