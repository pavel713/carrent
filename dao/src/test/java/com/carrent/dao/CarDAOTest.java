package com.carrent.dao;

import com.carrent.entities.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"/dao-config-test.xml"})
@Transactional
public class CarDAOTest {

    @Autowired
    private CarDAO carDAO;
    private Car car;






    @Test
    public void testCarDaoExists() {
        assertNotNull(carDAO);
    }

    @Test
    public void testFindAll() {
        List list = carDAO.findAll();
        Assert.assertEquals(list.size(),1);
    }

}












