package com.example.springmvcproducto2.models.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "tiene", schema = "mydb")
public class TieneEntity {


    @Id
    @OneToOne
    private MenuEntity menuId;


    @Id
    @OneToOne(mappedBy = "")
    private UsuarioEntity usuarioId;



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
