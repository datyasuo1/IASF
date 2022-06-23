package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.OrderDetail;
import com.example.shoppingcart.repository.OrderDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Iterable<OrderDetail> findAll(){
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetail> findById(Integer id){
        return orderDetailRepository.findById(id);
    }

    public OrderDetail save(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);
    }
}
