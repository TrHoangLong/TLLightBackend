package com.example.common.domain.cust;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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
}
