package com.carrent.web.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/")
    public String showHomePage() {
        return "main";
    }
}

