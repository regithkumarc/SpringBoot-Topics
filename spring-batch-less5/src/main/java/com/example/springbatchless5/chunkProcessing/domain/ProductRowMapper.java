package com.example.springbatchless5.chunkProcessing.domain;

import com.example.springbatchless5.chunkProcessing.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements org.springframework.jdbc.core.RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        System.out.println("Result set Object = " + resultSet);
        Product product = new Product();
        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setProductCategory(resultSet.getString("product_category"));
        product.setProductPrice(resultSet.getInt("product_price"));
        return product;
    }
}
