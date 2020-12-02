package com.carrent.web.controller;

import com.carrent.dao.entities.Category;
import com.carrent.dto.CarDTO;
import com.carrent.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("cars/economy")
    public String showEconomyCarsPage(Model model) {
        List<CarDTO> carByCategory = carService.findCarByCategory(Category.ECONOMY);
        model.addAttribute("carList", carByCategory);
        return "cars-economy";
    }

    @GetMapping("cars/standard")
    public String showStandardCarsPage(Model model) {
        List<CarDTO> carByCategory = carService.findCarByCategory(Category.STANDARD);
        model.addAttribute("carList", carByCategory);
        return "cars-standard";
    }

    @GetMapping("cars/luxury")
    public String showLuxuryCarsPage(Model model) {
        List<CarDTO> carByCategory = carService.findCarByCategory(Category.LUXURY);
        model.addAttribute("carList", carByCategory);
        return "cars-luxury";
    }
}



