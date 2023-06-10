package com.example.backend.customer.service;

import com.example.common.base.Cred;
import com.example.common.domain.product.CustProductDisplay;
import com.example.common.domain.product.Product;

import java.util.List;

public interface ICustProductService {
    List<CustProductDisplay> productGetList(Cred cred, Product product) throws Exception;
}
