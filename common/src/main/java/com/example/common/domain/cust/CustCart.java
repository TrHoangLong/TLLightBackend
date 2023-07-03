package com.example.common.domain.cust;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustCart implements Serializable {
    private String custCartId;
    private String custUserId;
    private String productId;
    private String productName;
    private Double quantity;
    private Double productPrice;
    private Double totalCart;
    private Integer status;

    private String linkProductImage;
    private String productImage;
}
