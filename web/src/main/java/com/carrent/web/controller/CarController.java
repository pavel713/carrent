package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.service.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String findAllCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "cars";
    }


    @PostMapping("/car_add")
    public String createCar(Car car) {
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("car-delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        carService.delete(id);
        return "redirect:/cars";
    }


    @PostMapping("/update-car")
    public String updateCar(Car car) {
        carService.save(car);
        return "redirect:/cars";
    }


    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable Long id) {
        return this.carService.getCarById(id);
    }
}

