package com.example.backend.admin.service;

import com.example.common.base.Cred;
import com.example.common.domain.product.Product;
import com.example.common.domain.product.ProductCategories;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IProductService {

    //==================ProductGroup=========================//
    List<ProductCategories> productCategoriesGet(Cred cred, ProductCategories productGroup) throws Exception;
    void productCategoriesInsert(Cred cred, ProductCategories productGroup) throws Exception;
    void productCategoriesUpdate(Cred cred, ProductCategories productGroup) throws Exception;

    void productCategoriesInsertExcel(Cred cred, List<ProductCategories> categoriesList) throws Exception;

    //==================Product=========================//
    List<Product> productGet(Cred cred, Product product) throws Exception;
    Product productReload(Cred cred, Product product) throws Exception;
    void productInsert(Cred cred, HttpServletRequest request) throws Exception;
    void productUpdate(Cred cred, HttpServletRequest request) throws Exception;
}
