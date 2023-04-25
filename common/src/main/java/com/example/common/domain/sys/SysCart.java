package com.example.common.domain.sys;

import java.io.Serializable;

public class SysCart implements Serializable {
    private Integer sysCartID;
    private String sysUserId;
    private String productId;
    private Integer quantity;
    private Double productPrice;
    private Integer status;
    private String productName;
    private Double toalCart;

    public Integer getSysCartID() {
        return sysCartID;
    }

    public void setSysCartID(Integer sysCartID) {
        this.sysCartID = sysCartID;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getToalCart() {
        return toalCart;
    }

    public void setToalCart(Double toalCart) {
        this.toalCart = toalCart;
    }
}
