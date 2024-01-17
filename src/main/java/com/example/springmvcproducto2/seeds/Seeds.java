package com.example.springmvcproducto2.seeds;

import com.example.springmvcproducto2.models.entity.MenuEntity;
import com.example.springmvcproducto2.models.entity.ProductoEntity;
import com.example.springmvcproducto2.repository.MenuRepository;
import com.example.springmvcproducto2.repository.ProductRepository;

public class Seeds {
    private MenuRepository menuRepository;
    private ProductRepository productRepository;

    public Seeds(MenuRepository menuRepository, ProductRepository productRepository)  {
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
    }

    public void generateSeeds(){
        MenuEntity menuLibanes = new MenuEntity("Mediterraneo", 33);
        menuRepository.save(menuLibanes);

        ProductoEntity productPollo = new ProductoEntity("Pollo",5.00);
        ProductoEntity productSeitan = new ProductoEntity("Seitan",7.00);
        ProductoEntity productTofu = new ProductoEntity("Tofu",6.50);
        ProductoEntity productTernera = new ProductoEntity("Ternera",5.50);
        ProductoEntity productSetas = new ProductoEntity("Setas",2.00);
        productRepository.save(productPollo);
        productRepository.save(productSeitan);
        productRepository.save(productTofu);
        productRepository.save(productTernera);
        productRepository.save(productSetas);
    }
}