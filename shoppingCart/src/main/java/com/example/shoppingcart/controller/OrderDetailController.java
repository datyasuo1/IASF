package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.OrderDetail;
import com.example.shoppingcart.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/orderDetail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<OrderDetail>> getList(){
        return ResponseEntity.ok(orderDetailService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody OrderDetail orderDetail){
        return ResponseEntity.ok(orderDetailService.save(orderDetail));
    }
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<OrderDetail> optionalOrderDetail =  orderDetailService.findById(id);
        if (!optionalOrderDetail.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalOrderDetail.get());
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody OrderDetail updateOrderDetail){
        Optional<OrderDetail> optionalOrderDetail =  orderDetailService.findById(id);
        if (!optionalOrderDetail.isPresent()){
            ResponseEntity.badRequest().build();
        }
        OrderDetail orderDetail = optionalOrderDetail.get();
        orderDetail.setUnitPrice(updateOrderDetail.getUnitPrice());
        return ResponseEntity.ok(orderDetailService.save(orderDetail));
    }

}
