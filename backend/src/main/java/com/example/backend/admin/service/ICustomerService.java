package com.example.backend.admin.service;

import com.example.common.base.Cred;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustOrders;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.cust.CustomerUserDisplay;

import java.util.List;

public interface ICustomerService {
    List<CustomerUserDisplay> getCustomerUser(Cred cred, CustomerUser user) throws Exception;
    void insertCustomerUser(Cred cred, CustomerUser user) throws Exception;
    void updateCustomerUser(Cred cred, CustomerUser user) throws Exception;
    void deleteCustomerUser(Cred cred, CustomerUser user) throws Exception;

    List<CustCart> getCustCart(Cred cred, CustCart custCart) throws Exception;

    List<CustOrders> getCustOrders(Cred cred, CustOrders custOrders) throws Exception;
    void updateStatusCustOrders(Cred cred, List<CustOrders> custOrders) throws Exception;
    void cancelCustOrders(Cred cred, CustOrders custOrders) throws Exception;
    void cancelConfirmCustOrders(Cred cred, List<CustOrders> custOrders) throws Exception;
    List<CustOrders> getHistCustOrders(Cred cred, CustOrders custOrders) throws Exception;
}
