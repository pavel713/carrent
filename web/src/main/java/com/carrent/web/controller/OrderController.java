package com.carrent.web.controller;

import com.carrent.dao.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {


    @GetMapping("/order")
    public String getOrder(Model model) {
        model.addAttribute("user", new User());
        return "order";
    }




}
