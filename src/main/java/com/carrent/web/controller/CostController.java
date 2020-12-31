package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import com.carrent.dto.UserDTO;
import com.carrent.service.CarService;
import com.carrent.service.OrderService;
import com.carrent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class CostController {

    private final OrderService orderService;
    private final CarService carService;
    private final UserService userService;

    @GetMapping("/cost")
    public String showCar(Model model, @RequestParam("car_id") Long carId, OrderDTO order) {
        CarDTO carById = carService.getCarById(carId);
        model.addAttribute("carById", carById);
        model.addAttribute("order", order);
        return "cost";
    }

    @PostMapping(value = "/cost/{carId}")
    public String setFinalCost(String startDate, String endDate, @PathVariable Long carId, Model model) {
        OrderDTO saved = orderService.save(startDate, endDate, carId);
        UserDTO currentUser = userService.getCurrentUser();
        CarDTO carById = carService.getCarById(carId);
        model.addAttribute("user", currentUser);
        model.addAttribute("order", saved);
        model.addAttribute("car", carById);
        return "result";
    }

}
