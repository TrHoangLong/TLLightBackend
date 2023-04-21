package com.example.common.domain.sys;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {

    private String SysUserId;
    private String UserName;
    private String MobileNo;
    private Integer Gender;
    private Date Birthday;
    private String Email;
    private String Password;
    private Integer Status;
    private String Address;
    private String Remarks;

    public String getSysUserId() {
        return SysUserId;
    }

    public void setSysUserId(String sysUserId) {
        SysUserId = sysUserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public Integer getGender() {
        return Gender;
    }

    public void setGender(Integer gender) {
        Gender = gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }
}
