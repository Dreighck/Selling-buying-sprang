package com.example.sellingbuyingsprang.service;

import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDAlreadyExistsException;
import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDDoesntExistException;
import com.example.sellingbuyingsprang.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(int id) throws ProductWithTheIDDoesntExistException;
    Product addNewProduct(Product product) throws ProductWithTheIDAlreadyExistsException;
    void deleteProduct(int id) throws ProductWithTheIDDoesntExistException;
    Product updateProduct(Product product) throws ProductWithTheIDAlreadyExistsException, ProductWithTheIDDoesntExistException;
    Product sellProduct(int id) throws ProductWithTheIDDoesntExistException;
}
