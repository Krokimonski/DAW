package com.Games.games.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "juego")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJuego;
    @Column(name="TITULO", length=50, nullable=false, unique=false)
    private String titulo;
    @Column(name="DESCRIPCION", length=50, nullable=false, unique=false)
    private String descripcion;
    @Column(name="PRECIO", length=50, nullable=false, unique=false)
    private Double precio;


    public Game(Long idJuego, String titulo, String descripcion, Double precio) {
        this.idJuego = idJuego;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Game() {
    }

    public Long getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Long idJuego) {
        this.idJuego = idJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
