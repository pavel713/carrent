package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.User;
import com.carrent.service.service.CarService;
import com.carrent.service.service.OrderService;
import com.carrent.service.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private final CarService carService;


    public OrderController(CarService carService) {
        this.carService = carService;

    }


    @GetMapping("/order")
    public String getOrder(Model model) {
        model.addAttribute("user", new User());
        return "order";
    }

    @GetMapping("order/new")
    public String addCar() {
        return "order";
    }

    @PostMapping("order/new")
    public String orderCar(@RequestParam("carId") Long id) {
        Car car = carService.getCarById(id);
        return "redirect:order";

    }
}
