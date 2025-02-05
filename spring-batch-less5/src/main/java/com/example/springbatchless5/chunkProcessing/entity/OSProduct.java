package com.example.springbatchless5.chunkProcessing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "OS_PRODUCT_DETAILS")
public class OSProduct {
    @Id
    private Integer productId;
    private String productName;

    //@Pattern(regexp = "Mobile|Tablet|Tv|Sports")
    private String productCategory;

    @Max(100000)
    private Integer productPrice;

    private Integer taxPercent;

    private String sku;

    private Integer shippingRate;

    public OSProduct(){}

    public OSProduct(Integer productId, String productName, String productCategory, Integer productPrice, Integer taxPercent, String sku, Integer shippingRate) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.taxPercent = taxPercent;
        this.sku = sku;
        this.shippingRate = shippingRate;
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

    public Integer getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Integer taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(Integer shippingRate) {
        this.shippingRate = shippingRate;
    }

    @Override
    public String toString() {
        return "OSProduct{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
