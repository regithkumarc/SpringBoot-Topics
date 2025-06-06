package com.example.springbatchgreater5.chunkProcessing.repository;

import com.example.springbatchgreater5.chunkProcessing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
