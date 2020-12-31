package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import com.carrent.dto.UserDTO;
import com.carrent.service.CarService;
import com.carrent.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultController {

    private final UserService userService;
    private final CarService carService;

    public ResultController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }


    @GetMapping("/result")
    public String showFinalePage(@RequestParam("car_id") Long carId, Model model, OrderDTO order) {
        UserDTO currentUser = userService.getCurrentUser();
        CarDTO carById = carService.getCarById(carId);
        model.addAttribute("user", currentUser);
        model.addAttribute("order", order);
        model.addAttribute("car", carById);
        return "result";
    }


}
