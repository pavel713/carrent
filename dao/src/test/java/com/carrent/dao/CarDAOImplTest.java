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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"/dao-config-test.xml"})

public class CarDAOImplTest {

    @Autowired
    private CarDAO carDAO;


    @Test
    public void testCarDaoExists(){assertNotNull(carDAO);}

    @Test
    public void testFindAll() {
        List list = carDAO.findAll();
        Assert.assertEquals(list.size(), 10);

    

    }





}












