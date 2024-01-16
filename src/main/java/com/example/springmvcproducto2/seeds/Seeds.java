package com.example.springmvcproducto2.seeds;

import com.example.springmvcproducto2.models.entity.MenuEntity;
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
        MenuEntity menuLibanes = new MenuEntity("a", 33);
        menuRepository.save(menuLibanes);

        /*Product productPollo = new Product("Pollo",5.00);
        Product productSeitan = new Product("Seitan",7.00);
        Product productTofu = new Product("Tofu",6.50);
        Product productTernera = new Product("Ternera",5.50);
        Product productSetas = new Product("Setas",2.00);
        productRepository.save(productPollo);
        productRepository.save(productSeitan);
        productRepository.save(productTofu);
        productRepository.save(productTernera);
        productRepository.save(productSetas);*/
    }
}