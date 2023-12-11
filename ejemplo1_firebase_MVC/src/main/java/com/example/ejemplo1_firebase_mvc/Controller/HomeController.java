package com.example.ejemplo1_firebase_mvc.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping({"/","/home",})
    public String home(@RequestParam(name = "nombre", required = true, defaultValue = "Iker") String nombre, Model model) {
        model.addAttribute("nombre", nombre);
        return "home";

    }
}
