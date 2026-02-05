package com.demo.web_1.service;

import com.demo.web_1.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> data = new ArrayList<>(Arrays.asList(
            new Product(101, "iphone", 80000),
            new Product(102, "samsung", 60000),
            new Product(103, "oppo", 40000)
    ));

    public List<Product> getProducts() {
        return data;
    }

    public Product getProductById(int prodId) {
        return data.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(100, "No Item", 0)); // safer than .get()
    }

    public void addProduct(Product prod){
        data.add(prod);
    }

    public void updateProduct(Product prod) {
        data.replaceAll(p -> p.getProdId() == prod.getProdId() ? prod : p);
    }

    public void deleteProduct(int prodId) {
        data.removeIf(p -> p.getProdId() == prodId);
    }
}
