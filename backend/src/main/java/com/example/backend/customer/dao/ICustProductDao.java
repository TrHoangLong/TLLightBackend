package com.example.backend.customer.dao;

import com.example.common.base.Cred;
import com.example.common.domain.product.Product;

import java.util.List;

public interface ICustProductDao {
    List<Product> getList(Cred cred, Product product) throws Exception;
}
