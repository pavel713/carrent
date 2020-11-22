package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.User;
import com.carrent.service.CarService;
import com.carrent.service.OrderService;
import com.carrent.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"car", "order"})
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
    public User getCurrentUser() {
        return userService.getUserFromSecurityContext();
    }


    @GetMapping("/order")
    public String setOrder(@RequestParam("carId") Long carId, Model model) {
        Car car = carService.getCarById(carId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findUserByUsername(name);
        model.addAttribute("userId", user);
        model.addAttribute("car", car);
        model.addAttribute("order", new Order());
        return "order";
    }


    @PostMapping("order/submit")
    public String submitOrder(Order order){
        User user = userService.getUserFromSecurityContext();
        order.setUsers(user);
        orderService.save(order);
        return "redirect:/cost";
    }
}
