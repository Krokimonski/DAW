package com.Games.games.Service;

import com.Games.games.DTO.OrderDTO;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    void deleteOrder(Long id);
}
