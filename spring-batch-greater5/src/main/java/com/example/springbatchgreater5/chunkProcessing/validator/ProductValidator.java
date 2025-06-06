package com.example.springbatchgreater5.chunkProcessing.validator;

import com.example.springbatchgreater5.chunkProcessing.entity.Product;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

import java.util.Arrays;
import java.util.List;

public class ProductValidator implements Validator<Product> {

    List<String> validProductList = Arrays.asList("Mobile","Tablet","Tv","Sports");

    @Override
    public void validate(Product product) throws ValidationException {
        if(!validProductList.contains(product.getProductCategory())){
            throw new ValidationException("Invalid Product Category");
        }

        if(product.getProductPrice() > 100000) {
            throw new ValidationException("Invalid Product Price");
        }
    }
}
