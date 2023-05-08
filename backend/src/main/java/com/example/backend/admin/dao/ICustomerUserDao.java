package com.example.backend.admin.dao;

import com.example.common.base.Cred;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.cust.CustomerUserDisplay;

import java.util.List;

public interface ICustomerUserDao {
    List<CustomerUserDisplay> get(Cred cred, CustomerUser user) throws Exception;
    String insert(Cred cred, CustomerUser user) throws Exception;
    void update(Cred cred, CustomerUser user) throws Exception;
    void delete(Cred cred, CustomerUser user) throws Exception;
}
