package com.example.springbatchless5.chunkProcessing.processor;

import com.example.springbatchless5.chunkProcessing.entity.OSProduct;
import com.example.springbatchless5.chunkProcessing.entity.Product;
import org.springframework.batch.item.ItemProcessor;

public class TransformProductItemProcessor implements ItemProcessor<Product, OSProduct> {
    @Override
    public OSProduct process(Product product) throws Exception {
        System.out.println("Transform Product item ProcessorExecuted...");

        OSProduct osProduct = new OSProduct();
        osProduct.setProductId(product.getProductId());
        osProduct.setProductName(product.getProductName());
        osProduct.setProductCategory(product.getProductCategory());
        osProduct.setProductPrice(product.getProductPrice());
        osProduct.setTaxPercent(product.getProductCategory().equals("Sports") ? 5 : 18);
        osProduct.setSku(product.getProductCategory().substring(0,3) + product.getProductId());
        osProduct.setShippingRate(product.getProductPrice() < 1000 ? 75 : 0);

        return osProduct;
    }
}
