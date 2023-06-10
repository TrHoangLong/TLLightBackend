package com.example.backend.customer.service;

import com.example.common.base.Cred;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustOrders;
import com.example.common.domain.cust.CustomerUser;

import java.util.List;

public interface ICustService {
    String custLogin(Cred cred, CustomerUser user) throws Exception;

    void custSignUp(CustomerUser user) throws Exception;

    CustomerUser custUserGetEmail(Cred cred, CustomerUser user) throws Exception;

    void custUpdateCustomerUser(Cred cred, CustomerUser user) throws Exception;
    CustomerUser custGetBuyIdCustomerUser(Cred cred, CustomerUser user) throws Exception;

    List<CustCart> getListCustCart(Cred cred, CustCart custCart) throws Exception;

    void insertCustCart(Cred cred, CustCart obj) throws Exception;

    void updateCustCart(Cred cred, CustCart obj) throws Exception;

    void deleteCustCart(Cred cred, CustCart obj) throws Exception;

    void cartOrderCustOrders(Cred cred, List<CustOrders> body) throws Exception;
    void productOrderCustOrder(Cred cred, CustOrders body) throws Exception;

    List<CustOrders> getListCustOrderForCust(Cred cred, CustOrders custOrders) throws Exception;
    void cancelRequireCustOrder(Cred cred, CustOrders custOrders) throws Exception;
}
