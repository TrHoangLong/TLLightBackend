package com.example.backend.admin.service;

import com.example.common.base.Cred;
import com.example.common.domain.sys.SysCart;
import com.example.common.domain.sys.SysOrder;
import com.example.common.domain.sys.SysUser;

import java.util.List;

public interface ISysService {

    List<SysUser> sysUserGetList(Cred cred, SysUser user) throws Exception;
    void sysUserInser(Cred cred, SysUser user) throws Exception;
    String sysUserLogin(Cred cred, SysUser user) throws Exception;
    void sysUserDelete(Cred cred, SysUser user) throws Exception;

    List<SysCart> getSysCart(Cred cred, SysCart obj) throws Exception;
    void insertSysCart(Cred cred, SysCart obj) throws Exception;
    void updateSysCart(Cred cred, SysCart obj) throws Exception;
    void deleteSysCart(Cred cred, List<SysCart> obj) throws Exception;
    void orderSysCart(Cred cred, List<SysOrder> obj) throws Exception;

    List<SysOrder> getSysOrder(Cred cred, SysOrder sysOrder) throws Exception;
    void orderSysOrder(Cred cred, SysOrder sysOrder) throws Exception;
    void updateStatusSysOrder(Cred cred, List<SysOrder> sysOrder) throws Exception;
    void cancelSysOrder(Cred cred, List<SysOrder> sysOrder) throws Exception;
    List<SysOrder> getHistSysOrder(Cred cred, SysOrder sysOrder) throws Exception;

    void systemCloseDate(Cred cred) throws Exception;
}
