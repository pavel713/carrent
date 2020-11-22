package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Order;
import com.carrent.service.CarService;
import com.carrent.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String setCost(Model model, Car car) {
        model.addAttribute("carById", car);

        return "cost";
    }

    @PostMapping("/cost")
    public String setFinalCost(Order order, Car car) {
        long days = orderService.calculateDateInterval(order.getStartDate(), order.getEndDate());
        order.setCost(car.getPrice() * days);
        orderService.save(order);
        return "redirect:/result";

    }


}
