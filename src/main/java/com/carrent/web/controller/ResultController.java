package com.carrent.web.controller;

import com.carrent.dao.entities.Order;
import com.carrent.dao.entities.UserAuth;
import com.carrent.service.UserAuthService;
import com.carrent.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"car", "order"})
public class ResultController {

    private final UserAuthService userAuthService;

    public ResultController(UserService userService, UserAuthService userAuthService) {
        this.userAuthService = userAuthService;

    }


    @GetMapping("/result")
    public String showFinalPage(Model model, UserAuth user, Order orderId) {
        UserAuth currentUser = userAuthService.getUserFromSecurityContext();
        model.addAttribute("user", user);
        model.addAttribute("order", orderId);
        return "result";
    }
}
