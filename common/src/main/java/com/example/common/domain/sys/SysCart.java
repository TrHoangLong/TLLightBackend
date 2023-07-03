package com.example.common.domain.sys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SysCart implements Serializable {
    private Integer sysCartID;
    private String sysUserId;
    private String productId;
    private Integer quantity;
    private Double productPrice;
    private Integer status;
    private String productName;
    private Double toalCart;
}
