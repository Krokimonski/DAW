package com.Games.games.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name="NOMBRE", length=50, nullable=false, unique=false)
    private String nombre;

    @Column(name="EMAIL", length=50, nullable=false, unique=false)
    private String email;

    @Column(name="PASSWORD", length=50, nullable=false, unique=false)
    private String password;


    public User(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public Long getIdUsuario() {return idUsuario;}

    public void setIdUsuario(Long idUsuario) {this.idUsuario = idUsuario;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
