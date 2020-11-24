package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import com.carrent.dto.CarDTO;
import com.carrent.service.CarService;
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
    public List<CarDTO> showEconomyCarsPage() {
        return carService.findCarByCategory(Category.ECONOMY);
    }


    @GetMapping("/cars-standard")
    public List<CarDTO> showStandardCarsPage() {
        return carService.findCarByCategory(Category.STANDARD);
    }

    @GetMapping("/cars-luxury")
    public List<CarDTO> showLuxuryCarsPage() {
        return carService.findCarByCategory(Category.LUXURY);
    }
}



