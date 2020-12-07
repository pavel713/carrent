package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.repository.CarRepository;
import com.carrent.service.helper.ExcelHelper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ExcelService {

    private final CarRepository carRepository;

    public ExcelService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public ByteArrayInputStream load() {
        List<Car> cars = carRepository.findAll();
        return ExcelHelper.carsToExcel(cars);
    }
}

