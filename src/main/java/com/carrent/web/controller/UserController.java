package com.carrent.web.controller;

import com.carrent.dao.entities.User;
import com.carrent.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/registration")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model)  {
        if (userService.isExists(user)) {
            model.addAttribute("message", "User Already exist");
           return "/registration";
        }

        userService.save(user);
        return "redirect:login";

    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

}
