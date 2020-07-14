package com.carrent.controller;

import com.carrent.entities.Car;
import com.carrent.service.CarService;
import com.carrent.service.CarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    private final CarsServiceImpl carsService;

    @Autowired
    public CarController(CarsServiceImpl carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/cars")
    public String findAll(Model model) {
        List<Car> cars = carsService.listCars();
        model.addAttribute("cars", cars);
        return "car-list";
    }

    @GetMapping("/car-create")
    public String createUserForm(Car car) {
        return "car-create";
    }

    @PostMapping("/car-create")
    public String createUser(Car car) {
        carsService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("car-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        carsService.delete(id);
        return "redirect:/cars";
    }

    @GetMapping("/update-car/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        Car car = carsService.getCarById(id);
        model.addAttribute("user", car);
        return "update-car";
    }

    @PostMapping("/update-car")
    public String updateUser(Car car) {
        carsService.save(car);
        return "redirect:/cars";
    }
}

