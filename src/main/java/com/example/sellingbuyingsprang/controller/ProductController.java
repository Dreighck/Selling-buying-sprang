package com.example.sellingbuyingsprang.controller;

import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDAlreadyExistsException;
import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDDoesntExistException;
import com.example.sellingbuyingsprang.model.Product;
import com.example.sellingbuyingsprang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity;
        responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("user/{userID}/products")
    public ResponseEntity<?> addProductHandler(@RequestBody Product product, @PathVariable String userID){
        ResponseEntity<?> responseEntity;
        try {
            Product prod=new Product();
            prod.setUser(userID);
            prod = productService.addNewProduct(product);
            responseEntity = new ResponseEntity<>(prod, HttpStatus.CREATED);
        }catch (ProductWithTheIDAlreadyExistsException e){
            responseEntity = new ResponseEntity<>("Failed to store, Duplicate",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("user/{userID}/products")
    public ResponseEntity<Product> updateProductHandler(@RequestBody Product product, @PathVariable String userID) throws ProductWithTheIDDoesntExistException, ProductWithTheIDAlreadyExistsException {
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @DeleteMapping("/user/{userID}/products/{prodId}")
    public ResponseEntity<?> deleteProductHandler(@PathVariable("prodId") int id, @PathVariable String userID) throws ProductWithTheIDDoesntExistException {
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
