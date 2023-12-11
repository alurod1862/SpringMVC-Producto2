package com.example.ejemplo1_firebase_mvc.Controller;


import com.example.ejemplo1_firebase_mvc.Models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class CoffeeShopsController {

    @GetMapping("coffe")
    public String coffee(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Iker");
        usuario.setApellido("Rodriguez");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario " + usuario.getNombre());
        return "coffe";
    }
}
