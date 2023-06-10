package com.example.backend.customer.dao;

import com.example.common.base.Cred;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.sys.SysUser;

public interface ICustomerUserCustDao {
    CustomerUser getByUserEmail(Cred cred, String email) throws Exception;
    String insert(CustomerUser user) throws Exception;

    void update(Cred cred, CustomerUser user) throws Exception;
    CustomerUser getByUserId(Cred cred, CustomerUser user) throws Exception;

}
