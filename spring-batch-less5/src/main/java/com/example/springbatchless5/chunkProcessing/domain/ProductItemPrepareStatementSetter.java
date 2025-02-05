package com.example.springbatchless5.chunkProcessing.domain;

import com.example.springbatchless5.chunkProcessing.entity.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductItemPrepareStatementSetter implements org.springframework.batch.item.database.ItemPreparedStatementSetter<Product> {
    @Override
    public void setValues(Product product, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1,product.getProductId());
        preparedStatement.setString(2,product.getProductName());
        preparedStatement.setString(3,product.getProductCategory());
        preparedStatement.setInt(4,product.getProductPrice());
    }
}
