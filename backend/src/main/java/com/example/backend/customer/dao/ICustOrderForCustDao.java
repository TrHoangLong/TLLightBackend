package com.example.backend.customer.dao;

import com.example.common.base.Cred;
import com.example.common.domain.cust.CustOrders;

import java.util.List;

public interface ICustOrderForCustDao {
    void custCartOrder(Cred cred, CustOrders custOrders) throws Exception;
    void productOrder(Cred cred, CustOrders custOrders) throws Exception;

    List<CustOrders> getList(Cred cred, CustOrders custOrders) throws Exception;
    void cancelRequire(Cred cred, CustOrders custOrders) throws Exception;
}
