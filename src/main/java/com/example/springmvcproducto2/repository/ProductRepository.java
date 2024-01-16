package com.example.springmvcproducto2.repository;

import com.example.springmvcproducto2.models.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductoEntity, Integer> {
}
