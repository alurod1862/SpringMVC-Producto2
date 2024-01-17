package com.example.springmvcproducto2.restControllers;


import com.example.springmvcproducto2.service.menuService.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api")
@RestController
public class MenuRestController {
    @Autowired
    private MenuService menuService;

    @DeleteMapping("/menu/delete/{id}")
    @ResponseBody
    public RestResponse deleteMenu(@PathVariable Integer id){
        menuService.delete(id);
        return new RestResponse().isOk("El menú "+id+" ha sido borrado",
                HttpStatus.ACCEPTED);
    }
}
