package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.User;
import com.carrent.service.CarService;
import com.carrent.service.UserService;
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


    @GetMapping("/car/add")
    public String getSignUpCar(Model model) {
        model.addAttribute("car", new Car());
        return "carAdd";
    }

    @PostMapping("/car/add")
    public String signUpCar(Car car) {
        carService.save(car);
        return "redirect:/admin/cars";
    }

    @GetMapping("cars")
    public String carListView(Model model) {
        List<Car> carList = carService.findAll();
        model.addAttribute("carList", carList);
        return "carsList";
    }

    @GetMapping("car-delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        carService.getCarById(id);
        return "redirect:/cars";
    }

    @GetMapping("/car/update/{id}")
    public String updateCarForm(@PathVariable("id") Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "carUpdate";
    }

    @PostMapping("/car/update")
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
