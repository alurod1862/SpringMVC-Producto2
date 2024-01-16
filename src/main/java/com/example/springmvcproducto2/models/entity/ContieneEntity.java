package com.example.springmvcproducto2.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "contiene", schema = "mydb", catalog = "")
public class ContieneEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "menu_id", nullable = false)
    private int menuId;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "producto_id", nullable = false)
    private int productoId;


   }
