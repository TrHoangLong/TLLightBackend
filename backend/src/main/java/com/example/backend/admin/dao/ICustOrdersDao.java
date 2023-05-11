package com.example.backend.admin.dao;

import com.example.common.base.Cred;
import com.example.common.domain.cust.CustOrders;

import java.util.List;

public interface ICustOrdersDao {
    List<CustOrders> get(Cred cred, CustOrders custOrders) throws Exception;
    void updateStatus(Cred cred, CustOrders custOrders) throws Exception;
    void cancel(Cred cred, CustOrders custOrders) throws Exception;
    void cancelConfirm(Cred cred, CustOrders custOrders) throws Exception;
    List<CustOrders> getHist(Cred cred, CustOrders custOrders) throws Exception;
}
