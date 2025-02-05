package com.example.springbatchless5.chunkProcessing.domain;

import com.example.springbatchless5.chunkProcessing.entity.Product;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ProductFieldsetMapper implements FieldSetMapper<Product> {
    @Override
    public Product mapFieldSet(FieldSet fieldSet) throws BindException {
        Product product = new Product();
        product.setProductId(fieldSet.readInt("product_id"));
        product.setProductName(fieldSet.readString("product_name"));
        product.setProductCategory(fieldSet.readString("product_category"));
        product.setProductPrice(fieldSet.readInt("product_price"));
        return product;
    }
}
