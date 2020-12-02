package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import com.carrent.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"carDTO", "orderDTO"})
public class CostController {

    private final OrderService orderService;

    public CostController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/cost")
    public String setCost(Model model, CarDTO car) {
        model.addAttribute("carById", car);
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
