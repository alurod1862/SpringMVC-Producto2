package com.example.springmvcproducto2.models.entity;

import javax.persistence.*;


import java.util.Objects;

@Entity
@javax.persistence.Table(name = "menu", schema = "mydb")
public class MenuEntity {

    public MenuEntity(String name, double precio) {
        this.setNombre(name);
        this.setPrecio(precio);
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    private int id;

    public MenuEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "precio", nullable = true)
    private double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    }



