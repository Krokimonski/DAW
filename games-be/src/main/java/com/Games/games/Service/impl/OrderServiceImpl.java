package com.Games.games.Service.impl;

import com.Games.games.DTO.OrderDTO;
import com.Games.games.Entity.Order;
import com.Games.games.Mapper.OrderMapper;
import com.Games.games.Repository.OrderRepository;
import com.Games.games.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.toEntity(orderDTO);
        Order newOrder = orderRepository.save(order);

        return OrderMapper.toDTO(newOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
