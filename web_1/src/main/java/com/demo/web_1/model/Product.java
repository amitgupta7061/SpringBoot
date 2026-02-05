package com.demo.web_1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
public class Product {
    private int prodId;
    private String prodName;
    private int price;

    public Product() {

    }

    public Product(int prodId, String prodName, int price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    public int getProdId() {
        return this.prodId;
    }
}
