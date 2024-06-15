package com.Games.games.DTO;

import java.util.Date;

public class OrderDTO {
    private Long idPedido;
    private Date fecha;
    private Long idUsuario;
    private String estadoPago;
    private Double total;

    public OrderDTO() {
    }

    public OrderDTO(Long idPedido, Date fecha, Long idUsuario, String estadoPago, Double total) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.estadoPago = estadoPago;
        this.total = total;
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
