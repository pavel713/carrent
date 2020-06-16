package com.carrent.service;


import com.carrent.entities.Car;
import com.carrent.dao.CarDAO;


import com.carrent.util.SystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CarsService extends BaseService<Car> {

    @Autowired
    private CarDAO carDAO;

    public List<Car> findAll() throws ServiceException {
        List<Car> all;
        try {
            all = carDAO.findAll();
        } catch (HibernateException e) {
            SystemLogger.getInstance().setLogger(getClass(), e);
            throw new ServiceException("ERROR_GET_LIST_CARS");
        }
        return all;
    }


    }






