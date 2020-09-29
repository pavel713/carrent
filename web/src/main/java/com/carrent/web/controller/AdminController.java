package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.User;
import com.carrent.service.service.CarService;
import com.carrent.service.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize(value = "hasAuthority('ADMIN')")
public class AdminController {

    private final CarService carService;
    private final UserService userService;

    public AdminController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "admin";
    }


    @GetMapping("/car-add")
    public String createCarForm(Car car) {
        return "carAdd";
    }

    @PostMapping("/car-add")
    public String addCar(Car car) {
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

    @GetMapping("/users")
    public String userList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "userList";
    }

}
