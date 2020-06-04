package com.carrent.dao;

import com.carrent.Car;
import com.carrent.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/dao-config-test.xml"})
@Transactional(propagation = Propagation.SUPPORTS)
public class CarDAOImplTest {

    @Autowired
    private BaseDAO baseDAO;
    @Autowired
    private CarDAO carDAOImpl;
    private Car car;

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Test
    public void testFindAll() {
        List list = carDAOImpl.findAll(0,1);
        Assert.assertEquals(list.size(), 10);
    }

}












