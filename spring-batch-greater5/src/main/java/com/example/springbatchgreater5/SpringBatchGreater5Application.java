package com.example.springbatchgreater5;

import com.example.springbatchgreater5.chunkProcessing.entity.Product;
import com.example.springbatchgreater5.chunkProcessing.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBatchGreater5Application {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchGreater5Application.class, args);
	}

	@PostConstruct
	public void storeProductDetails() {
		List<Product> productList = Arrays.asList(
				new Product(1,"Samsung s22","Mobile",1500),
				new Product(2,"Samsung Tab","Tablet",1000),
				new Product(3,"Nikon sD700","Camera",700),
				new Product(4,"Samsung Crystal","Tv",500),
				new Product(5,"Yonex Batminten","Sports",100)
		);

		productRepository.saveAll(productList);
	}
}
