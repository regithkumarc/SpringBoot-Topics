package com.example.springbatchgreater5.chunkProcessing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PRODUCT_DETAILS_OUTPUT")
public class ProductDetailsOutput {

    @Id
    private Integer productId;
    private String productName;
    private String productCategory;
    private Integer productPrice;

    public ProductDetailsOutput() {}

    public ProductDetailsOutput(Integer productId, String productName, String productCategory, Integer productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}
