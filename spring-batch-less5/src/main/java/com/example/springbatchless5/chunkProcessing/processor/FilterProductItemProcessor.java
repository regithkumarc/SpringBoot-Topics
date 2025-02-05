package com.example.springbatchless5.chunkProcessing.processor;

import com.example.springbatchless5.chunkProcessing.entity.Product;
import org.springframework.batch.item.ItemProcessor;

public class FilterProductItemProcessor implements ItemProcessor<Product,Product> {
    @Override
    public Product process(Product product) throws Exception {
        if(product.getProductPrice() > 500) {
            return product;
        } else {
            return null;
        }
    }
}
