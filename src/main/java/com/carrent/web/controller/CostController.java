package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import com.carrent.service.CarService;
import com.carrent.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes({"CarDTO", "OrderDTO"})
public class CostController {

    private final OrderService orderService;
    private final CarService carService;

    public CostController(OrderService orderService, CarService carService) {
        this.orderService = orderService;
        this.carService = carService;

    }

    @GetMapping("/cost")
    public String showCar(Model model, @RequestParam("car_id") Long carId, OrderDTO order) {
        CarDTO carById = carService.getCarById(carId);
        model.addAttribute("carById", carById);
        model.addAttribute("order", order);
        return "cost";
    }

    @PostMapping("/cost/{carById}")
    public String setFinalCost(@RequestBody OrderDTO order, @PathVariable(value = "carById") Long carId) {
        CarDTO car = carService.getCarById(carId);
        long days = orderService.calculateDateInterval(order.getStartDate(), order.getEndDate());
        order.setCost(car.getPrice() * days);
        orderService.save(order);
        return "redirect:/result";

    }


}
