package com.carrent.dao;

import com.carrent.Car;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"/dao-config-test.xml"})

public class CarDAOTest {

    @Autowired
    private CarDAO carDAO;
    private Car car;
    @Autowired
    private SessionFactory sessionFactory;



    @Test
    public void setUp(){
        carDAO.save(car);
        Car actual = (car) ;
        Assert.assertEquals(car, actual);
    }

    @Test
    public void testCarDaoExists() {
        assertNotNull(carDAO);
    }

    @Test
    public void testFindAll() {


    }

}












