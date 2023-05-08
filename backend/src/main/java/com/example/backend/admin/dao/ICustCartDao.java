package com.example.backend.admin.dao;

import com.example.common.base.Cred;
import com.example.common.domain.cust.CustCart;

import java.util.List;

public interface ICustCartDao {
    List<CustCart> get(Cred cred, CustCart custCart) throws Exception;
}
