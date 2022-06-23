package com.example.shoppingcart.service;


import com.example.shoppingcart.entity.Order;
import com.example.shoppingcart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Integer id){
        return orderRepository.findById(id);
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }
}
