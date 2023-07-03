package com.example.common.domain.cust;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class CustomerUserDisplay implements Serializable {
    private String custUserId;
    private String custName;
    private Integer gender;
    private Date birthday;
    private String mobileNo;
    private String email;
    private String address;
    private Integer status;
    private String remarks;
}
