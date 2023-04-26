package com.example.backend.admin.dao;

import com.example.common.base.Cred;
import com.example.common.domain.sys.SysOrder;

import java.util.List;

public interface ISysOrderDao {
    List<SysOrder> get(Cred cred, SysOrder sysOrder) throws Exception;
    void order(Cred cred, SysOrder sysOrder) throws Exception;
    void updateStatus(Cred cred, SysOrder sysOrder) throws Exception;
    void cancel(Cred cred, SysOrder sysOrder) throws Exception;
}
