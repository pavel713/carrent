package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import com.carrent.dto.UserDTO;
import com.carrent.service.CarService;
import com.carrent.service.PriceService;
import com.carrent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final CarService carService;
    private final UserService userService;
    private final PriceService priceService;

    @ModelAttribute("currentUser")
    public UserDTO getCurrentUser() {
        return userService.getCurrentUser();
    }


    @GetMapping("/order")
    public String setOrder(@RequestParam("carId") Long carId, Model model) {
        CarDTO carById = carService.getCarById(carId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        UserDTO userByName = userService.findUserByName(name);
        model.addAttribute("userId", userByName);
        model.addAttribute("carById", carById);
        model.addAttribute("order", new OrderDTO());
        return "order";
    }


    @PostMapping("/order/{carId}")
    public String submitOrder(OrderDTO order, @PathVariable Long carId, Model model) {
        Long price = priceService.calculatePrice(order.getStartDate(), order.getEndDate(), carId);
        order.setCost(price);
        CarDTO carById = carService.getCarById(carId);
        model.addAttribute("carById", carById);
        model.addAttribute("order", order);
        return "cost";
    }
}
