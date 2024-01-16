package com.example.springmvcproducto2.service.menuService;


import com.example.springmvcproducto2.models.entity.MenuEntity;
import com.example.springmvcproducto2.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService implements IMenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<MenuEntity> findAll(){
        return this.menuRepository.findAll();
    }

    @Override
    public Optional<MenuEntity> findById(Integer id) {
        return menuRepository.findById(id);
    }

    @Override
    public MenuEntity create(MenuEntity menu) {
        return menuRepository.save(menu);
    }

    @Override
    public MenuEntity update(MenuEntity menuEntity) {
        MenuEntity currentMenu = menuRepository.findById(menuEntity.getId()).get();
        currentMenu.setPrecio(menuEntity.getPrecio());
        currentMenu.setNombre(menuEntity.getNombre());
        return menuRepository.save(currentMenu);
    }

    @Override
    public void delete(Integer id) {
        Optional<MenuEntity> menu = menuRepository.findById(id);
        System.out.println(menu);
        menuRepository.deleteById(id);
    }
}
