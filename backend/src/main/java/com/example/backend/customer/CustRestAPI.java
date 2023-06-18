package com.example.backend.customer;


import com.example.backend.auth.jwt.CustJWTAuthenticalServiceImpl;
import com.example.backend.customer.service.ICustProductService;
import com.example.backend.customer.service.ICustService;
import com.example.common.base.BaseResponse;
import com.example.common.base.Cred;
import com.example.common.base.GTException;
import com.example.common.domain.Token;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustOrders;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.product.CustProductDisplay;
import com.example.common.domain.product.Product;
import com.example.common.domain.product.ProductCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type", origins = "*")
@RequestMapping("/apicust")
public class CustRestAPI {

    @Autowired
    private CustJWTAuthenticalServiceImpl custJwtAuthenticalService;

    @Autowired
    private ICustService custService;

    @Autowired
    private ICustProductService productService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse login(@RequestBody CustomerUser body) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = new Cred();
            CustomerUser customerUser = custService.custUserGetEmail(cred, body);
            cred.setUserId(customerUser.getCustUserId());
            String token = custService.custLogin(cred, body);
            response.setData(token);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse signUp( @RequestBody CustomerUser body) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            custService.custSignUp(body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse logout(@RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            custJwtAuthenticalService.logout(token);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/checklogin", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse checkLogin(@RequestBody Token body) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(body.getToken());
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/customeruser/getbyid", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse customerUserGetById(@RequestBody CustomerUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            CustomerUser customerUser = custService.custGetBuyIdCustomerUser(cred, body);
            response.setData(customerUser);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/customeruser/update", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse customerUserUpdate(@RequestBody CustomerUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            custService.custUpdateCustomerUser(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/product/get", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productGet(@RequestBody Product body) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = new Cred();
            List<CustProductDisplay> productDisplayList = productService.productGetList(cred, body);
            response.setData(productDisplayList);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/categories/get", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse categoriesGet(@RequestBody ProductCategories body) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = new Cred();
            List<ProductCategories> productDisplayList = productService.categoriesGetList(cred, body);
            response.setData(productDisplayList);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/custcart/getforcust", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse custCartGet(@RequestBody CustCart body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            List<CustCart> resultData = custService.getListCustCart(cred, body);
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

    @RequestMapping(value = "/custcart/insert", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse custCartInsert(@RequestBody CustCart body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            custService.insertCustCart(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/custcart/update", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse custCartUpdate(@RequestBody CustCart body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            custService.updateCustCart(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/custcart/delete", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse custCartDelete(@RequestBody CustCart body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            custService.deleteCustCart(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/custorders/cartorder", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse cartOrderCustOrder(@RequestBody List<CustOrders> body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            custService.cartOrderCustOrders(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/custorders/productorder", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productOrderCustOrder(@RequestBody CustOrders body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            custService.productOrderCustOrder(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/custorders/getforcust", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse custGetCustOrder(@RequestBody CustOrders body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            List<CustOrders> results = custService.getListCustOrderForCust(cred, body);
            response.setData(results);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/custorders/cancelrequire", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse custCancelCustOrder(@RequestBody CustOrders body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = custJwtAuthenticalService.checkSession(token);
            custService.cancelRequireCustOrder(cred, body);
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
