package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.service.service.CarsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {

    private CarsServiceImpl carsService;

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



    @PostMapping("/update-car")
    public String updateUser(Car car) {
        carsService.save(car);
        return "redirect:/cars";
    }
}

