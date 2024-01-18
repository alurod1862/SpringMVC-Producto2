package com.example.springmvcproducto2.models.entity;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "tiene", schema = "mydb")
public class TieneEntity implements Serializable {


    @Id
    @OneToOne
    private MenuEntity menuId;


    @Id
    @OneToOne
    private UsuarioEntity usuarioId;



}
