package com.carrent.web.controller;

import com.carrent.dao.entities.User;
import com.carrent.service.service.UserService;
import com.carrent.web.util.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthController {

    private final UserService userService;
    private final UserValidator userValidator;

    public AuthController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/registration")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String signUp(User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {

            return "registration";
        }
        userService.save(user);
        return "order";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
