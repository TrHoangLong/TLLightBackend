package com.example.backend.admin.dao;

import com.example.common.base.Cred;
import com.example.common.domain.sys.SysCart;
import com.example.common.domain.sys.SysOrder;

import java.util.List;

public interface ISysCartDao {
    List<SysCart> get(Cred cred, SysCart obj) throws Exception;
    void insert(Cred cred, SysCart obj) throws Exception;
    void update(Cred cred, SysCart obj) throws Exception;
    void delete(Cred cred, SysCart obj) throws Exception;
    void order(Cred cred, SysOrder obj) throws Exception;
}
