package com.example.springmvcproducto2.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "tiene", schema = "mydb", catalog = "")
@jakarta.persistence.IdClass(com.example.springmvcproducto2.models.entity.TieneEntityPK.class)
public class TieneEntity {
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
    @jakarta.persistence.Column(name = "usuario_id", nullable = false)
    private int usuarioId;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TieneEntity that = (TieneEntity) o;
        return menuId == that.menuId && usuarioId == that.usuarioId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, usuarioId);
    }
}
