package com.example.springmvcproducto2.models.entity;



import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contiene", schema = "mydb", catalog = "")
public class ContieneEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "menu_id", nullable = false)
    private int menuId;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto_id", nullable = false)
    private int productoId;


   }
