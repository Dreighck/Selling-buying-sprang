package com.example.sellingbuyingsprang.service;

import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDAlreadyExistsException;
import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDDoesntExistException;
import com.example.sellingbuyingsprang.model.Product;

import java.util.List;

public interface TransactionService {

    List<Product> getAllProducts();

    Product getProductById(int id) throws ProductWithTheIDDoesntExistException;

    Product addNewProduct(Product product) throws ProductWithTheIDAlreadyExistsException;

    void purchaseProduct(int id) throws ProductWithTheIDDoesntExistException;
}
