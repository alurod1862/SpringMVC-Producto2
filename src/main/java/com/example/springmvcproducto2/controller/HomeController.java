package com.example.springmvcproducto2.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }
}
