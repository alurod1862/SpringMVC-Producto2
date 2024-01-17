package com.example.springmvcproducto2.service.productService;

import com.example.springmvcproducto2.models.entity.ProductoEntity;
import com.example.springmvcproducto2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductoEntity> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<ProductoEntity> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductoEntity create(ProductoEntity product) {
        return productRepository.save(product);
    }

    @Override
    public ProductoEntity update(ProductoEntity products) {
        ProductoEntity currentProducts= productRepository.findById(products.getId()).get();
        currentProducts.setPrecio(products.getPrecio());
        currentProducts.setNombre(products.getNombre());
        return productRepository.save(currentProducts);
    }

    @Override
    public void delete(Integer id) {
        Optional<ProductoEntity> product=productRepository.findById(id);
        System.out.println(product);
        productRepository.deleteById(id);

    }

}

