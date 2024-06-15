package com.Games.games.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedido")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    @Column(name="FECHA", length=50, nullable=false, unique=false)
    private Date fecha;
    @Column(name="ID_USUARIO", length=50, nullable=false, unique=false)
    private Long idUsuario;
    @Column(name="ESTADO_PAGO", length=50, nullable=false, unique=false)
    private String estadoPago;
    @Column(name="TOTAL", length=50, nullable=false, unique=false)
    private Double total;


    public Order(Long idPedido, Date fecha, Long idUsuario, String estadoPago, Double total) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.estadoPago = estadoPago;
        this.total = total;
    }

    public Order() {
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
