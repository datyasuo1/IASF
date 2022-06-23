package com.example.shoppingcart.repository;

import com.example.shoppingcart.ShoppingCartApplication;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.enums.ProductSimpleStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShoppingCartApplication.class})
@ActiveProfiles("test")
class ProductRepositoryTest {
    @Autowired
    private  ProductRepository productRepository;
    @Test
    public void testSaveProduct(){
        Product product = Product.builder()
                .id(UUID.randomUUID().toString())
                .name("Xe dap")
                .slug("xe")
                .description("good")
                .detail("nice")
                .thumbnails("anh.jpg")
                .price(new BigDecimal(200))
                .status(ProductSimpleStatus.ACTIVE)
                .build();
        productRepository.save(product);

    }
}