package com.example.springmvcproducto2.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "contiene", schema = "mydb", catalog = "")
@jakarta.persistence.IdClass(com.example.springmvcproducto2.models.entity.ContieneEntityPK.class)
public class ContieneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "menu_id", nullable = false)
    private int menuId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "producto_id", nullable = false)
    private int productoId;

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContieneEntity that = (ContieneEntity) o;
        return menuId == that.menuId && productoId == that.productoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, productoId);
    }
}
