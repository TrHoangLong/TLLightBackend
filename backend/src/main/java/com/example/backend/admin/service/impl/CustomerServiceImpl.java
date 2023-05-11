package com.example.backend.admin.service.impl;

import com.example.backend.admin.auth.mail.IEmailService;
import com.example.backend.admin.dao.ICustCartDao;
import com.example.backend.admin.dao.ICustOrdersDao;
import com.example.backend.admin.dao.ICustomerUserDao;
import com.example.backend.admin.service.ICustomerService;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustOrders;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.cust.CustomerUserDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerUserDao customerUserDao;

    @Autowired
    private IEmailService emailService;

    @Autowired
    private ICustCartDao custCartDao;

    @Autowired
    private ICustOrdersDao custOrdersDao;

    @Override
    public List<CustomerUserDisplay> getCustomerUser(Cred cred, CustomerUser user) throws Exception {
        return customerUserDao.get(cred, user);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void insertCustomerUser(Cred cred, CustomerUser user) throws Exception {
        String custUserId = customerUserDao.insert(cred, user);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateCustomerUser(Cred cred, CustomerUser user) throws Exception {
        customerUserDao.update(cred, user);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteCustomerUser(Cred cred, CustomerUser user) throws Exception {
        customerUserDao.delete(cred, user);
    }

    @Override
    public List<CustCart> getCustCart(Cred cred, CustCart custCart) throws Exception {
        return custCartDao.get(cred, custCart);
    }

    @Override
    public List<CustOrders> getCustOrders(Cred cred, CustOrders custOrders) throws Exception {
        return custOrdersDao.get(cred, custOrders);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateStatusCustOrders(Cred cred, List<CustOrders> custOrders) throws Exception {
        for (CustOrders orders: custOrders) {
            custOrdersDao.updateStatus(cred, orders);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void cancelCustOrders(Cred cred, CustOrders custOrders) throws Exception {
        custOrdersDao.cancel(cred, custOrders);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void cancelConfirmCustOrders(Cred cred, List<CustOrders> custOrders) throws Exception {
        for (CustOrders orders: custOrders) {
            custOrdersDao.cancelConfirm(cred, orders);
        }
    }

    @Override
    public List<CustOrders> getHistCustOrders(Cred cred, CustOrders custOrders) throws Exception {
        return custOrdersDao.getHist(cred, custOrders);
    }
}
