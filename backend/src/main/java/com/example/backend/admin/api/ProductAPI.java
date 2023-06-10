package com.example.backend.admin.api;

import com.example.backend.auth.jwt.JWTAuthenticalServiceImpl;
import com.example.backend.admin.service.IProductService;
import com.example.common.base.BaseResponse;
import com.example.common.base.Cred;
import com.example.common.base.GTException;
import com.example.common.domain.product.Product;
import com.example.common.domain.product.ProductCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type", origins = "*")
@RequestMapping("/api/product")
public class ProductAPI {

    @Autowired
    private JWTAuthenticalServiceImpl jwtAuthenticalService;

    @Autowired
    private IProductService productService;

    //==============================ProductCategories===============================//
    @RequestMapping(value = "/productcategories/get", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productCategoriesGet(@RequestBody ProductCategories body, @RequestHeader("Authorization") String token) throws Exception{
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            List<ProductCategories> resultData =  productService.productCategoriesGet(cred, body);
            response.setData(resultData);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        }  catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/productcategories/insert", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productCategoriesInsert(@RequestBody ProductCategories body, @RequestHeader("Authorization") String token) throws Exception{
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            productService.productCategoriesInsert(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        }  catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/productcategories/update", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productCategoriesUpdate(@RequestBody ProductCategories body, @RequestHeader("Authorization") String token) throws Exception{
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            productService.productCategoriesUpdate(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        }  catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/productcategories/insertexcel", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productCategoriesInserExcel(@RequestBody List<ProductCategories> body, @RequestHeader("Authorization") String token) throws Exception{
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            productService.productCategoriesInsertExcel(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        }  catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    //==============================Product===============================//
    @RequestMapping(value = "/product/get", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productGet(@RequestBody Product body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            List<Product> resultData = productService.productGet(cred, body);
            response.setData(resultData);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        }  catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/product/reload", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productReload(@RequestBody Product body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            Product resultData = productService.productReload(cred, body);
            response.setData(resultData);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        }  catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/product/insert", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productInsert(HttpServletRequest body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            productService.productInsert(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        }  catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse productUpdate(HttpServletRequest body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            productService.productUpdate(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        }  catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }
}
