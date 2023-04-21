package com.example.backend.admin.dao;

import com.example.common.base.Cred;
import com.example.common.domain.product.ProductCategories;

import java.util.List;

public interface IProductCategoriesDao {
    List<ProductCategories> getlist(Cred cred,ProductCategories productCategoriesp) throws Exception;
    void insert(Cred cred,ProductCategories productCategoriesp) throws Exception;
    void update(Cred cred,ProductCategories productCategoriesp) throws Exception;
}
