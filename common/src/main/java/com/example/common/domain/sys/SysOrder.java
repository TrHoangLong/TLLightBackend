package com.example.common.domain.sys;

import java.io.Serializable;
import java.util.Date;

public class SysOrder implements Serializable {
    private Date sysOrderDate;
    private Integer sysOrderId;
    private String sysUserId;
    private Integer orderStatus;
    private String custName;
    private String mobileNo;
    private String address;
    private String productId;
    private Double quantity;
    private Double productPrice;
    private Double totalPrice;
    private String updatedUserId;
    private Date updatedTime;
    private Integer sysCartID;

    public Date getSysOrderDate() {
        return sysOrderDate;
    }

    public void setSysOrderDate(Date sysOrderDate) {
        this.sysOrderDate = sysOrderDate;
    }

    public Integer getSysOrderId() {
        return sysOrderId;
    }

    public void setSysOrderId(Integer sysOrderId) {
        this.sysOrderId = sysOrderId;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public Integer getSysCartID() {
        return sysCartID;
    }

    public void setSysCartID(Integer sysCartID) {
        this.sysCartID = sysCartID;
    }
}
