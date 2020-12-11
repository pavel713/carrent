package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.repository.CarRepository;
import com.carrent.service.helper.ExcelHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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


    public void save(MultipartFile file) {
        try {
            List<Car> cars = ExcelHelper.excelToCars(file.getInputStream());
            carRepository.saveAll(cars);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}

