package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import com.carrent.service.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final CarService carService;

    public MainController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "main";
    }

    @GetMapping("/cars-economy")
    public List<Car> showEconomyCarsPage() {
        return carService.findCarByCategory(Category.ECONOM);
    }

    @GetMapping("/cars-standart")
    public List<Car> showStandardCarsPage() {
        return carService.findCarByCategory(Category.STANDART);
    }

    @GetMapping("/cars-luxury")
    public List<Car> showLuxuryCarsPage() {
        return carService.findCarByCategory(Category.LUXURY);
    }
}



