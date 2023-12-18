package com.example.springmvcproducto2.models.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "pedido", schema = "mydb", catalog = "")
@IdClass(com.example.springmvcproducto2.models.entity.PedidoEntityPK.class)
public class PedidoEntity {
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
    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
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
        PedidoEntity that = (PedidoEntity) o;
        return id == that.id && usuarioId == that.usuarioId && Objects.equals(direccion, that.direccion) && Objects.equals(npedido, that.npedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direccion, npedido, usuarioId);
    }
}
