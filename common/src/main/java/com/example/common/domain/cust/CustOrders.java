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
    private Integer custCartId;

    private String productImage;
    private String linkProductImage;

    private String custName;
    private String address;
    private String mobileNo;


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

    public Integer getCustCartId() {
        return custCartId;
    }

    public void setCustCartId(Integer custCartId) {
        this.custCartId = custCartId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getLinkProductImage() {
        return linkProductImage;
    }

    public void setLinkProductImage(String linkProductImage) {
        this.linkProductImage = linkProductImage;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
