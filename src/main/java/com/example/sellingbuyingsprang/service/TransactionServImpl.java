package com.example.sellingbuyingsprang.service;

import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDAlreadyExistsException;
import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDDoesntExistException;
import com.example.sellingbuyingsprang.model.Product;

import com.example.sellingbuyingsprang.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServImpl implements TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

        @Override
        public List<Product> getAllProducts() {
            return transactionRepo.findAll();
        }

        @Override
        public Product getProductById(int id) throws ProductWithTheIDDoesntExistException {
            Optional<Product> optional = transactionRepo.findById(id);
            if (optional.isPresent())
                return transactionRepo.getReferenceById(id);
            throw new ProductWithTheIDDoesntExistException();
        }

        @Override
        public Product addNewProduct(Product product) throws ProductWithTheIDAlreadyExistsException {
            Optional<Product> optional = transactionRepo.findById(product.getId());
            if (optional.isEmpty()){
                return transactionRepo.save(product);
            }
            throw new ProductWithTheIDAlreadyExistsException();
        }

        @Override
        public void purchaseProduct(int id) throws ProductWithTheIDDoesntExistException {
            Optional<Product> optional = transactionRepo.findById(id);
            if (optional.isEmpty())
                throw new ProductWithTheIDDoesntExistException();
            transactionRepo.deleteById(id);
        }
    }


