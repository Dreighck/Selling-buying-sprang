package com.example.sellingbuyingsprang.repo;

import com.example.sellingbuyingsprang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
