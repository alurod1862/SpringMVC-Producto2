package com.example.springmvcproducto2.controller;

import com.example.springmvcproducto2.models.entity.MenuEntity;
import com.example.springmvcproducto2.service.menuService.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public String getMenus(Model model){
        model.addAttribute("menus", menuService.findAll());
        model.addAttribute("currentPage", "menus");
        return "home";
    }

    @GetMapping("/menu/{id}")
    public String getMenuDetail(Model model, @PathVariable Integer id) throws Exception {
        Optional<MenuEntity> menu = Optional.ofNullable(menuService.findById(id).orElseThrow(() -> new Exception("Menu" + id + " not found")));
        if(menu.isPresent()) {
            model.addAttribute("menu", menu.get());
            model.addAttribute("currentPage", "menus");
        }
        return "edit_menu";
    }

    @PostMapping("/menu/update/{id}")
    public String updateMenu(@PathVariable("id") Integer id,
                             @ModelAttribute("menu") MenuEntity menuDetails) throws Exception {
        Optional<MenuEntity> menu = Optional.ofNullable(menuService.findById(id).orElseThrow(() -> new Exception("Menu" + id + " not found")));
        if(menu.isPresent()){
            menu.get().setNombre(menuDetails.getNombre());
            menu.get().setPrecio(menuDetails.getPrecio());
            menuService.update(menu.get());
        }
        return "redirect:/menu/" + id;
    }

    @GetMapping("/menu/create")
    public String createMenu(Model model) {
        model.addAttribute("menu", new MenuEntity());
        model.addAttribute("currentPage", "menus");
        return "create_menu";
    }

    @PostMapping("/menu/save")
    public String newMenu(Model model, @ModelAttribute("menu") MenuEntity menu) {
        menuService.create(menu);
        return "redirect:/";
    }
}
