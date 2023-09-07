package com.mottakin.springsecurity.controller;

import com.mottakin.springsecurity.dto.Product;
import com.mottakin.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class MainController {
    @Autowired
    private ProductService service;
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome!!! This endpoint is not secure";
    }
    @GetMapping("/all")
    public List<Product> getAllTheProducts(){
        return service.getProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProduct(id);
    }

}
