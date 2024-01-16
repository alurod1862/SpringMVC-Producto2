package com.example.springmvcproducto2.service.menuService;

import com.example.springmvcproducto2.models.entity.MenuEntity;

import java.util.List;
import java.util.Optional;

public interface IMenuService {
    List<MenuEntity> findAll();
    Optional<MenuEntity> findById(Integer id);
    MenuEntity create(MenuEntity menu);
    MenuEntity update(MenuEntity menu);
    void delete(Integer id);
}
