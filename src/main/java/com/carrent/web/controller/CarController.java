package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dto.CarDto;
import com.carrent.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;

    }


    @GetMapping("/cars")
    public List<CarDto> findAllCars(Car car) {
        return carService.findAll()
                .stream()
                .map(carService::carToDto).collect(Collectors.toList());

    }
}



