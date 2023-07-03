package com.example.common.domain.sys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class SysUser implements Serializable {

    private String sysUserId;
    private String userName;
    private Integer role;
    private String password;
    private Integer status;
    private String remarks;
}
