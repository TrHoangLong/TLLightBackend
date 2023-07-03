package com.example.common.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ProductCategories implements Serializable {
    private String CategoryId;
    private String CategoryName;
    private Integer Status;
    private String CreatedUserId;
    private Date CreatedTime;
    private String UpdatedUserId;
    private Date UpdatedTime;
}
