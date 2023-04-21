package com.example.backend.admin.dao;

import com.example.common.base.Cred;
import com.example.common.domain.product.Product;

import java.util.List;

public interface IProductDao {

    List<Product> getList(Cred cred, Product obj) throws Exception;
    void insert(Cred cred, Product obj) throws Exception;
    void update(Cred cred, Product obj) throws Exception;
}
