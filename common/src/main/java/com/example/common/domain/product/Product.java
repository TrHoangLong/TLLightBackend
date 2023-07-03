package com.example.common.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Product implements Serializable {
    private String ProductId;
    private String CategoryId;
    private String ProductName;
    private String CategoryName;
    private Double ProductPrice;
    private String Wattage;
    private String Material;
    private String Battery;
    private String BatterySize;
    private String LightingTime;
    private String ChargingTime;
    private Double Quantity;
    private String ProductImage;
    private Integer Status;
    private String CreatedUserId;
    private Date CreatedTime;
    private String UpdatedUserId;
    private Date UpdatedTime;
    private String LinkProductImage;
    private String QuantityStatus;

    private Integer offset;
    private Integer limit;
    private Integer totalRows;
}