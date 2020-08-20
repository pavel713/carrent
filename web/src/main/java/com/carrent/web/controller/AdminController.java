package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.service.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private final CarService carService;

    public AdminController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car-create")
    public String createCarForm(Car car) {
        return "carAdd";
    }

    @PostMapping("/car-create")
    public String createCar(Car car) {
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("car-delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        carService.getCarById(id);
        return "redirect:/cars";
    }

    @GetMapping("/car-update/{id}")
    public String updateCarForm(@PathVariable("id") Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "carUpdate";
    }

    @PostMapping("/car-update")
    public String updateCar(Car car) {
        carService.save(car);
        return "redirect:/cars";
    }
}
