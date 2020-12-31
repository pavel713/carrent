package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.repository.CarRepository;
import com.carrent.service.helper.ExcelHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<Car> carList = carRepository.findAll();
        Set<Car> carSet = new HashSet<>(carList);
        Set<Car> finalList = new HashSet<>();
        try {
            Set<Car> cars = ExcelHelper.excelToCars(file.getInputStream());
            for (Car car : cars) {
                if (!carSet.contains(car)) {
                    finalList.add(car);
                }
            }
            carRepository.saveAll(finalList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Car> getAllCars() {

        return carRepository.findAll();
    }
}

