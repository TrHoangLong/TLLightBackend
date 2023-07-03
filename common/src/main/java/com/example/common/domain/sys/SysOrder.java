package com.example.common.domain.sys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
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

    private String productName;
}
