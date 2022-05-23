package com.example.sellingbuyingsprang.service;

import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDAlreadyExistsException;
import com.example.sellingbuyingsprang.exceptions.ProductWithTheIDDoesntExistException;
import com.example.sellingbuyingsprang.model.Product;
import com.example.sellingbuyingsprang.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isPresent())
            return productRepo.getReferenceById(id);
        throw new ProductWithTheIDDoesntExistException();
    }

    @Override
    public Product addNewProduct(Product product) throws ProductWithTheIDAlreadyExistsException {
        Optional<Product> optional = productRepo.findById(product.getId());
        if (optional.isEmpty()){
            return productRepo.save(product);
        }
        throw new ProductWithTheIDAlreadyExistsException();
    }

    @Override
    public void deleteProduct(int id) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isEmpty())
            throw new ProductWithTheIDDoesntExistException();
        productRepo.deleteById(id);
    }

    @Override
    public Product sellProduct(int id) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isEmpty())
            throw new ProductWithTheIDDoesntExistException();
        return productRepo.getReferenceById(id);
    }

    @Override
    public Product updateProduct(Product product) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(product.getId());
        if (optional.isPresent()){
            return productRepo.save(product);
        }
        throw new ProductWithTheIDDoesntExistException();
    }
}
