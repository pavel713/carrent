package com.carrent.web.controller;

import com.carrent.dao.entities.Order;
import com.carrent.dto.UserDTO;
import com.carrent.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"car", "order"})
public class ResultController {

    private final UserService userService;

    public ResultController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/result")
    public String showFinalPage(Model model, Order orderId) {
        UserDTO currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);
        model.addAttribute("order", orderId);
        return "result";
    }
}
