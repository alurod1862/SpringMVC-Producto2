package com.example.springmvcproducto2.controller;

import com.example.springmvcproducto2.service.menuService.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class HomeController {


    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("menus", menuService.findAll());
        model.addAttribute("currentPage", "home");
        return "home";
    }
}
