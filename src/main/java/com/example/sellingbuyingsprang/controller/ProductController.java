package com.example.sellingbuyingsprang.controller;

import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDAlreadyExistsException;
import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDDoesntExistException;
import com.example.sellingbuyingsprang.model.Product;
import com.example.sellingbuyingsprang.repo.ProductRepo;
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
    public ResponseEntity<List<Product>> getAllEmployees(){
        List<Product> products = productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity;
        responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/list_for_sale")
    public ResponseEntity<?> addProductHandler(@RequestBody Product product){
        ResponseEntity<?> responseEntity;
        try {
            Product prod = productService.addNewProduct(product);
            responseEntity = new ResponseEntity<>(prod, HttpStatus.CREATED);
        }catch (ProductWithTheIDAlreadyExistsException e){
            responseEntity = new ResponseEntity<>("Failed to store, Duplicate",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws ProductWithTheIDDoesntExistException, ProductWithTheIDAlreadyExistsException {
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{prodId}")
    public ResponseEntity<?> deleteProductHandler(@PathVariable("prodId") int id) throws ProductWithTheIDDoesntExistException {
        productService.sellProduct(id);
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    @DeleteMapping("/purchase/{prodId}")
    public ResponseEntity<?> sellProductHandler(@PathVariable("prodId") int id) throws ProductWithTheIDDoesntExistException {
        productService.sellProduct(id);
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

}
