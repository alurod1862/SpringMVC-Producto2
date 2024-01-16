package com.example.springmvcproducto2.models.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "tiene", schema = "mydb")
public class TieneEntity implements Serializable {


    @Id
    @OneToOne
    private MenuEntity menuId;


    @Id
    @OneToOne
    private UsuarioEntity usuarioId;



}
