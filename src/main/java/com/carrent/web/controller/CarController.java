package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()

    public String findAllCars(Model model) {
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("carList", cars);
        return "carsList";
    }
}



