package com.example.backend.admin.api;

import com.example.backend.admin.auth.jwt.JWTAuthenticalServiceImpl;
import com.example.backend.admin.service.ICustomerService;
import com.example.common.base.BaseResponse;
import com.example.common.base.Cred;
import com.example.common.base.GTException;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.cust.CustomerUserDisplay;
import com.example.common.domain.product.ProductCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type", origins = "*")
@RequestMapping("/api/customer")
public class CustomerAPI {

    @Autowired
    private JWTAuthenticalServiceImpl jwtAuthenticalService;

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/customeruser/get", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse customerUserGet(@RequestBody CustomerUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            List<CustomerUserDisplay> resultData = customerService.getCustomerUser(cred, body);
            response.setData(resultData);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/customeruser/insert", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse customerUserInsert(@RequestBody CustomerUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            customerService.insertCustomerUser(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorCode(ex.getMessage());
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/customeruser/update", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse customerUserUpdate(@RequestBody CustomerUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            customerService.updateCustomerUser(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/customeruser/delete", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse customerUserDelete(@RequestBody CustomerUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            customerService.deleteCustomerUser(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    //================================CustCart====================================
    @RequestMapping(value = "/custcart/get", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse custCartGet(@RequestBody CustCart body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            List<CustCart> resultData = customerService.getCustCart(cred, body);
            response.setData(resultData);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }
}
