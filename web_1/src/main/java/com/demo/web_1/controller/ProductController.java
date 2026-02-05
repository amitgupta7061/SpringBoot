package com.demo.web_1.controller;

import com.demo.web_1.model.Product;
import com.demo.web_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/products")
    public List<Product> getProduct(){
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product prod){
        service.addProduct(prod);
        return "Product added Successfully";
    }

    @PutMapping("/update")
    public String updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
        return "Data updated Successfully";
    }

    @DeleteMapping("/delete/{prodId}")
    public String deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
        return "Product Removed Successfully";
    }
}
