package com.example.sellingbuyingsprang.service;

import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDAlreadyExistsException;
import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDDoesntExistException;
import com.example.sellingbuyingsprang.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(int id) throws ProductWithTheIDDoesntExistException;
    Product addNewProduct(Product product) throws ProductWithTheIDAlreadyExistsException;
    void deleteEmployee(int id) throws ProductWithTheIDDoesntExistException;
    Product updateEmployee(Product product) throws ProductWithTheIDAlreadyExistsException, ProductWithTheIDDoesntExistException;
}
