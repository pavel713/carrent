package com.carrent.web.controller;

import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.User;
import com.carrent.dao.entities.UserAuth;
import com.carrent.dto.CarDTO;
import com.carrent.dto.OrderDTO;
import com.carrent.dto.UserDTO;
import com.carrent.service.CarService;
import com.carrent.service.OrderService;
import com.carrent.service.UserAuthService;
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
    private final UserAuthService userAuthService;


    public OrderController(CarService carService, OrderService orderService, UserService userService, UserAuthService userAuthService) {
        this.carService = carService;
        this.orderService = orderService;
        this.userAuthService = userAuthService;
    }

    @ModelAttribute("currentUser")
    public UserAuth getCurrentUser() {
        return userAuthService.getUserFromSecurityContext();
    }


    @GetMapping("/order")
    public String setOrder(@RequestParam("carId") Long carId, Model model) {
        CarDTO car = carService.getCarById(carId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        UserAuth user = userAuthService.findUserByUsername(name);
        model.addAttribute("userId", user);
        model.addAttribute("car", car);
        model.addAttribute("order", new Order());
        return "order";
    }


    @PostMapping("order/submit")
    public String submitOrder(OrderDTO order){
//        UserAuth user = userAuthService.getUserFromSecurityContext();
//        order.setUsers(user);
        orderService.save(order);
        return "redirect:/cost";
    }
}
