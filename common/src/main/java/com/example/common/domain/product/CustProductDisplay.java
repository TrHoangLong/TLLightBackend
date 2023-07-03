package com.example.common.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustProductDisplay {
    private String productId;
    private String categoryId;
    private String productName;
    private String categoryName;
    private Double productPrice;
    private String wattage;
    private String material;
    private String battery;
    private String batterySize;
    private String lightingTime;
    private String chargingTime;
    private String quantityStatus;
    private String linkProductImage;

    private Integer totalRows;
}
