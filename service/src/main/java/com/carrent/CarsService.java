package com.carrent;


import com.carrent.dao.CarDAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CarsService extends BaseService<Car> {

    @Autowired
    private CarDAO carDAO;



    }






