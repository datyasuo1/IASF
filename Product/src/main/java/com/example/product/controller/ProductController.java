package com.example.product.controller;

import com.example.product.entity.Products;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * http://localhost:8080/api/v1/products |GET| return list products
 * http://localhost:8080/api/v1/products |POST| create new products
 * http://localhost:8080/api/v1/products/1 |DELETE| delete list products
 * http://localhost:8080/api/v1/products/1 |GET| find by id
 * http://localhost:8080/api/v1/products/1 |PUT| update products
 *
 **/

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Products>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Products> crete(@RequestBody Products products) {
        return ResponseEntity.ok(productService.save(products));
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Products> optionalProducts = productService.findById(id);
        if (optionalProducts.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProducts.get());
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<Products> delete( @PathVariable String id){
        if (!productService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Products> update(@PathVariable String id, @RequestBody Products products) {
        Optional<Products> optionalProducts = productService.findById(id);
        if (!optionalProducts.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Products existProducts =optionalProducts.get();
        existProducts.setId(products.getId());
        existProducts.setProductName(products.getProductName());
        existProducts.setSlug(products.getSlug());
        existProducts.setDescription(products.getDescription());
        existProducts.setDetail(products.getDetail());
        existProducts.setImage(products.getImage());
        existProducts.setBrand(products.getBrand());
        existProducts.setUserCre(products.getUserCre());
        existProducts.setUserUp(products.getUserUp());
        existProducts.setUserDel(products.getUserDel());
        return ResponseEntity.ok(productService.save(existProducts));
    }
}
