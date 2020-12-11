package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import com.carrent.service.CarService;
import com.carrent.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"car", "order"})
public class CostController {

    private final OrderService orderService;
    private final CarService carService;

    public CostController(OrderService orderService, CarService carService) {
        this.orderService = orderService;
        this.carService = carService;

    }

    @GetMapping("/cost")
    public String showSessionCar(Model model, @RequestParam("car_id") Long carId) {
        CarDTO carById = carService.getCarById(carId);
        model.addAttribute("carById", carById);
        return "cost";
    }

    @PostMapping("/cost")
    public String setFinalCost(OrderDTO order, CarDTO car) {
        long days = orderService.calculateDateInterval(order.getStartDate(), order.getEndDate());
        order.setCost(car.getPrice() * days);
        orderService.save(order);
        return "redirect:/result";

    }


}
