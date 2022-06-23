package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.Order;
import com.example.shoppingcart.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Order>> getList(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Order order){
        return ResponseEntity.ok(orderService.save(order));
    }
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<Order> optionalOrder =  orderService.findById(id);
        if (!optionalOrder.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalOrder.get());
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Order updateOrder){
        Optional<Order> optionalOrder =  orderService.findById(id);
        if (!optionalOrder.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Order order = optionalOrder.get();
        order.setTotalPrice(updateOrder.getTotalPrice());
        order.setStatus(updateOrder.getStatus());
        return ResponseEntity.ok(orderService.save(order));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        Optional<Order> optionalOrder =  orderService.findById(id);
        if (!optionalOrder.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Order order = optionalOrder.get();
        if (order.getStatus() == -1){
            ResponseEntity.badRequest().build();
        }
        order.setStatus(-1);
        return ResponseEntity.ok(orderService.save(order));
    }

}
