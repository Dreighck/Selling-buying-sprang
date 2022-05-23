package com.example.sellingbuyingsprang.controller;

import com.example.sellingbuyingsprang.repo.ProductRepo;
import com.example.sellingbuyingsprang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    public ResponseEntity responseEntity;

    @Autowired
    private ProductService productService;


}
