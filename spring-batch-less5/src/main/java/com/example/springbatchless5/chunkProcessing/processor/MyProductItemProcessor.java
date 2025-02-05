package com.example.springbatchless5.chunkProcessing.processor;

import com.example.springbatchless5.chunkProcessing.entity.Product;
import org.springframework.batch.item.ItemProcessor;

public class MyProductItemProcessor implements ItemProcessor<Product,Product> {
    @Override
    public Product process(Product product) throws Exception {

        // Transformation input type and output type same
     /* System.out.println("Processor Executed...");
        return product;*/

        // Transformation input type and output type Different
        System.out.println("Processor Executed...");
        Integer price = product.getProductPrice();
        product.setProductPrice((int) (price - ((0.1) * price)));
        return product;
    }
}
