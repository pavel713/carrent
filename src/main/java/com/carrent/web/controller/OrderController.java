package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import com.carrent.dto.UserDTO;
import com.carrent.service.CarService;
import com.carrent.service.OrderService;
import com.carrent.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes({"carDTO", "orderDTO"})
public class OrderController {

    private final CarService carService;
    private final OrderService orderService;
    private final UserService userService;


    public OrderController(CarService carService, OrderService orderService, UserService userService) {
        this.carService = carService;
        this.orderService = orderService;
        this.userService = userService;
    }

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


    @PostMapping("/order/submit")
    public String submitOrder(OrderDTO order, RedirectAttributes redirectAttributes,
                              @RequestParam(value = "car_id") Long CarId) {

        orderService.save(order);
        redirectAttributes.addAttribute("car_id", CarId);
        return "redirect:/cost";
    }
}
