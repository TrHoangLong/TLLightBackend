package com.example.common.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductReload {
    private String ProductId;
    private String CategoryId;
    private String ProductName;
    private String CategoryName;
    private Double ProductPrice;
    private String wattage;
    private String material;
    private String battery;
    private String batterySize;
    private String lightingTime;
    private String chargingTime;
    private Double Quantity;
    private String ProductImage;
    private Integer Status;
    private String CreatedUserId;
    private Date CreatedTime;
    private String UpdatedUserId;
    private Date UpdatedTime;

    private String LinkProductImage;
}
