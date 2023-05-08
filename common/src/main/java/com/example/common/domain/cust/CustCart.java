package com.example.common.domain.cust;

import java.io.Serializable;

public class CustCart implements Serializable {
    private String custCartId;
    private String custUserId;
    private String productId;
    private String productName;
    private Double quantity;
    private Double productPrice;
    private Double totalCart;
    private Integer status;

    public String getCustCartId() {
        return custCartId;
    }

    public void setCustCartId(String custCartId) {
        this.custCartId = custCartId;
    }

    public String getCustUserId() {
        return custUserId;
    }

    public void setCustUserId(String custUserId) {
        this.custUserId = custUserId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getTotalCart() {
        return totalCart;
    }

    public void setTotalCart(Double totalCart) {
        this.totalCart = totalCart;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
