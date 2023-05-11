package com.example.common.domain.cust;

import java.util.Date;

public class CustOrders {
    private Date custOrderDate;
    private Integer custOrderId;
    private Integer orderStatus;
    private String custUserId;
    private String productId;
    private String productName;
    private Double quantity;
    private Double productPrice;
    private Double totalPrice;
    private String updatedUserId;
    private Date updatedTime;

    public Date getCustOrderDate() {
        return custOrderDate;
    }

    public void setCustOrderDate(Date custOrderDate) {
        this.custOrderDate = custOrderDate;
    }

    public Integer getCustOrderId() {
        return custOrderId;
    }

    public void setCustOrderId(Integer custOrderId) {
        this.custOrderId = custOrderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
