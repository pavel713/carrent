package com.carrent.web.controller;

import com.carrent.dao.entities.Role;
import com.carrent.dto.UserDTO;
import com.carrent.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/registration")
    public String addUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserDTO user, Model model) {
        if (userService.isExists(user)) {
            model.addAttribute("message", "User Already exist");
            model.addAttribute("user", user);
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);
        return "redirect:/login";

    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
