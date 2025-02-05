package com.example.springbatchless5.chunkProcessing.repository;

import com.example.springbatchless5.chunkProcessing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
