package com.example.backend.customer.dao;

import com.example.common.base.Cred;
import com.example.common.domain.product.Product;
import com.example.common.domain.product.ProductCategories;

import java.util.List;

public interface ICustProductDao {
    List<Product> getList(Cred cred, Product product) throws Exception;

    List<ProductCategories> getCategories(Cred cred, ProductCategories productCategories) throws Exception;
}
