package com.example.springmvcproducto2.models.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "pedido", schema = "mydb")
public class PedidoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "npedido", nullable = false, length = 45)
    private String npedido;

    public String getNpedido() {
        return npedido;
    }

    public void setNpedido(String npedido) {
        this.npedido = npedido;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioId;


    public UsuarioEntity getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuarioEntity usuarioId) {
        this.usuarioId = usuarioId;
    }

   }
