package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<Product> optionalProduct =  productService.findById(id);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Product updateProduct){
        Optional<Product> optionalProduct =  productService.findById(id);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Product product = optionalProduct.get();
        product.setName(updateProduct.getName());
        product.setDescription(updateProduct.getDescription());
        product.setImage(updateProduct.getImage());
        product.setPrice(updateProduct.getPrice());
        product.setQty(updateProduct.getQty());
        product.setStatus(updateProduct.getStatus());
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        Optional<Product> optionalProduct =  productService.findById(id);
        if (!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Product product = optionalProduct.get();
        if (product.getStatus() == -1){
            ResponseEntity.badRequest().build();
        }
        product.setStatus(-1);
        return ResponseEntity.ok(productService.save(product));
    }

}
