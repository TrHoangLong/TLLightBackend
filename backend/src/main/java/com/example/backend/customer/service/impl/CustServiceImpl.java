package com.example.backend.customer.service.impl;

import com.example.backend.auth.hash.MD5HashServiceImpl;
import com.example.backend.auth.jwt.CustJWTAuthenticalServiceImpl;
import com.example.backend.customer.dao.ICustCartForCustDao;
import com.example.backend.customer.dao.ICustOrderForCustDao;
import com.example.backend.customer.dao.ICustomerUserCustDao;
import com.example.backend.customer.service.ICustService;
import com.example.common.base.Cred;
import com.example.common.base.GTException;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustOrders;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustServiceImpl implements ICustService {


    @Autowired
    private MD5HashServiceImpl md5HashService;

    @Autowired
    private CustJWTAuthenticalServiceImpl jwtAuthenticalService;

    @Autowired
    private ICustomerUserCustDao customerUserCustDao;

    @Autowired
    private ICustCartForCustDao custCartForCustDao;

    @Autowired
    private ICustOrderForCustDao custOrderForCustDao;

    @Value("${image.config.imageProduct}")
    private String IMAGE_PRODUCT;

    @Override
    public String custLogin(Cred cred, CustomerUser user) throws Exception {
        CustomerUser customerUser = customerUserCustDao.getByUserEmail(cred, user.getEmail());

        if (customerUser.getEmail() == null) {
            throw new GTException("Tài khoản không đúng", null, null);
        }

        String md5Pass = md5HashService.hashMD5(user.getPassword());

        if (customerUser.getPassword().compareTo(md5Pass) != 0) {
            throw new GTException("Mật khẩu không đúng", null, null);
        }

        return jwtAuthenticalService.generateToken(cred);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void custSignUp(CustomerUser user) throws Exception {
        String custUserId = customerUserCustDao.insert(user);
    }

    @Override
    public CustomerUser custUserGetEmail(Cred cred, CustomerUser user) throws Exception {
        return customerUserCustDao.getByUserEmail(cred, user.getEmail());
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void custUpdateCustomerUser(Cred cred, CustomerUser user) throws Exception {
        customerUserCustDao.update(cred, user);
    }

    @Override
    public CustomerUser custGetBuyIdCustomerUser(Cred cred, CustomerUser user) throws Exception {
        return customerUserCustDao.getByUserId(cred, user);
    }

    @Override
    public List<CustCart> getListCustCart(Cred cred, CustCart custCart) throws Exception {
        List<CustCart> custCartList = new ArrayList<>();

        for(CustCart prd : custCartForCustDao.get(cred, custCart)) {
            String linkImageProduct = IMAGE_PRODUCT + prd.getProductImage();
            prd.setLinkProductImage(linkImageProduct);
            custCartList.add(prd);
        }

        return custCartList;
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void insertCustCart(Cred cred, CustCart obj) throws Exception {
        custCartForCustDao.insert(cred, obj);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void updateCustCart(Cred cred, CustCart obj) throws Exception {
        custCartForCustDao.update(cred, obj);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void deleteCustCart(Cred cred, CustCart obj) throws Exception {
        custCartForCustDao.delete(cred, obj);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void cartOrderCustOrders(Cred cred, List<CustOrders> body) throws Exception {
        for (CustOrders custOrders: body) {
            custOrderForCustDao.custCartOrder(cred, custOrders);
        }
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void productOrderCustOrder(Cred cred, CustOrders body) throws Exception {
        custOrderForCustDao.productOrder(cred, body);
    }

    @Override
    public List<CustOrders> getListCustOrderForCust(Cred cred, CustOrders custOrders) throws Exception {
        List<CustOrders> custOrdersList = new ArrayList<>();

        for (CustOrders custOrd : custOrderForCustDao.getList(cred, custOrders)) {
            String linkImageProduct = IMAGE_PRODUCT + custOrd.getProductImage();
            custOrd.setLinkProductImage(linkImageProduct);
            custOrdersList.add(custOrd);
        }

        return custOrdersList;
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void cancelRequireCustOrder(Cred cred, CustOrders custOrders) throws Exception {
        custOrderForCustDao.cancelRequire(cred, custOrders);
    }
}
