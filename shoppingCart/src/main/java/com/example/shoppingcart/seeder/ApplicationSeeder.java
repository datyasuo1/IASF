package com.example.shoppingcart.seeder;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationSeeder implements CommandLineRunner {

    boolean createSeedData = false;
    int numberOfProduct = 500;
    /*final OrderRepository orderRepository;*/
    final ProductRepository productRepository;
    Faker faker;

    public ApplicationSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        if(createSeedData){
            this.faker = new Faker();
        }
    }

    private void seedProduct() {
        List<Product> listProduct = new ArrayList<>();
        for (int i = 0; i < numberOfProduct; i++) {
            System.out.println(i + 1);
            Product product = new Product();
            product.setName(faker.name().title());
            product.setDescription(faker.lorem().sentence());
            product.setImage(faker.avatar().image());
            product.setQty(faker.number().numberBetween(10, 100));
            product.setPrice(Double.valueOf(faker.number().numberBetween(100, 200) * 10000));
            product.setStatus(1);
            listProduct.add(product);
            System.out.println(product.toString());
        }
        productRepository.saveAll(listProduct);
    }
}
