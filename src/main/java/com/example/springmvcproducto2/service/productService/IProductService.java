package com.example.springmvcproducto2.service.productService;

import com.example.springmvcproducto2.models.entity.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<ProductoEntity> findAll();
    Optional<ProductoEntity> findById(Integer i);
    ProductoEntity create(ProductoEntity Product);
    ProductoEntity update(ProductoEntity Product);
    void delete(Integer id);
}
