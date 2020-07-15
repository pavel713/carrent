package com.carrent.service.dao;

import com.carrent.dao.dao.CarDAO;
import com.carrent.dao.entities.Car;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"/dao-config-test.xml"})
@Transactional
public class CarDAOTest {

    @Resource
    private CarDAO carDAO;

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }


    @Test
    public void testUpdateCar(Car car) {
        this.carDAO.update(car);
        Assert.assertNotNull(car);


    }

    @Test
    public void testSaveCar(Car car) {
        this.carDAO.save(car);
    }


    @Test
    public void testCarDaoExists() {
        assertNotNull(carDAO);
    }


    @Test
    public List carList() {
        return this.carDAO.listCars();


    }

    @Test
    public void testDeleteCar(Long id) {
        this.carDAO.delete(id);
    }
}












