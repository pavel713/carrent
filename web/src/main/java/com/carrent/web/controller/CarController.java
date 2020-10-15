package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.service.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/cars")
    public String findAllCars(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("carList", cars);
        return "carsList";
    }


}
