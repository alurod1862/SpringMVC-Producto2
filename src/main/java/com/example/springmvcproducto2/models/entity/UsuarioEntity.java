package com.example.springmvcproducto2.models.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "mydb")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "apellidos", nullable = false, length = 45)
    private String apellidos;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "telefono", nullable = false, length = 45)
    private String telefono;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
