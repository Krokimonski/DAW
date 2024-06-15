package com.Games.games.Mapper;

import com.Games.games.DTO.OrderDTO;
import com.Games.games.Entity.Order;

public class OrderMapper {

    public static Order toEntity(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        Order order = new Order();
        order.setIdPedido(orderDTO.getIdPedido());
        order.setFecha(orderDTO.getFecha());
        order.setIdUsuario(orderDTO.getIdUsuario());
        order.setEstadoPago(orderDTO.getEstadoPago());
        order.setTotal(orderDTO.getTotal());

        return order;
    }

    public static OrderDTO toDTO(Order order) {
        if (order == null) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setIdPedido(order.getIdPedido());
        orderDTO.setFecha(order.getFecha());
        orderDTO.setIdUsuario(order.getIdUsuario());
        orderDTO.setEstadoPago(order.getEstadoPago());
        orderDTO.setTotal(order.getTotal());

        return orderDTO;
    }
}
