package com.example.backend.customer.dao;

import com.example.common.base.Cred;
import com.example.common.domain.cust.CustCart;

import java.util.List;

public interface ICustCartForCustDao {
    List<CustCart> get(Cred cred, CustCart obj) throws Exception;

    void insert(Cred cred, CustCart obj) throws Exception;

    void update(Cred cred, CustCart obj) throws Exception;

    void delete(Cred cred, CustCart obj) throws Exception;
}
