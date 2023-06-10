package com.example.common.domain.product;

import java.util.Date;

public class CustProductDisplay {
    private String productId;
    private String categoryId;
    private String productName;
    private String categoryName;
    private Double productPrice;
    private String description;
    private String quantityStatus;
    private String linkProductImage;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantityStatus() {
        return quantityStatus;
    }

    public void setQuantityStatus(String quantityStatus) {
        this.quantityStatus = quantityStatus;
    }

    public String getLinkProductImage() {
        return linkProductImage;
    }

    public void setLinkProductImage(String linkProductImage) {
        this.linkProductImage = linkProductImage;
    }
}
