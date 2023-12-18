package com.example.springmvcproducto2.models.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "PEDIDO", schema = "mydb", catalog = "")
public class PEDIDOEntity {
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
    @Column(name = "npedido", nullable = false, length = 45)
    private String npedido;

    public String getNpedido() {
        return npedido;
    }

    public void setNpedido(String npedido) {
        this.npedido = npedido;
    }

    @Basic
    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PEDIDOEntity that = (PEDIDOEntity) o;
        return id == that.id && Objects.equals(npedido, that.npedido) && Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, npedido, direccion);
    }
}
