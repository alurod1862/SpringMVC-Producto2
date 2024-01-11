package com.example.springmvcproducto2.models.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "menu", schema = "mydb")
public class MenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id", nullable = false)
    private int id;

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
    @Column(name = "precio", nullable = true, length = 45)
    private String precio;

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio);
    }
}
