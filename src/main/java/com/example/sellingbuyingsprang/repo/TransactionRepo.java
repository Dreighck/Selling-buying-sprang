package com.example.sellingbuyingsprang.repo;

import com.example.sellingbuyingsprang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface TransactionRepo extends JpaRepository<Product,Integer> {
}
