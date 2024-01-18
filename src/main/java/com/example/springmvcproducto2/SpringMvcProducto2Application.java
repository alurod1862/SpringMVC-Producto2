package com.example.springmvcproducto2;

import com.example.springmvcproducto2.repository.MenuRepository;
import com.example.springmvcproducto2.repository.ProductRepository;
import com.example.springmvcproducto2.seeds.Seeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMvcProducto2Application {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcProducto2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Seeds seeds = new Seeds(menuRepository, productRepository);
            seeds.generateSeeds();
        };
    }
}
