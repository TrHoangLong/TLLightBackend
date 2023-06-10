package com.example.backend.customer.service.impl;

import com.example.backend.customer.dao.ICustProductDao;
import com.example.backend.customer.service.ICustProductService;
import com.example.common.base.Cred;
import com.example.common.domain.product.CustProductDisplay;
import com.example.common.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustProductServiceImpl implements ICustProductService {

    @Autowired
    private ICustProductDao custProductDao;

    @Value("${image.config.imageProduct}")
    private String IMAGE_PRODUCT;

    @Override
    public List<CustProductDisplay> productGetList(Cred cred, Product product) throws Exception {
        List<CustProductDisplay> resultData = new ArrayList<>();

        for (Product pro : custProductDao.getList(cred, product)) {
            CustProductDisplay display = new CustProductDisplay();

            display.setProductId(pro.getProductId());
            display.setCategoryId(pro.getCategoryId());
            display.setProductPrice(pro.getProductPrice());
            display.setProductName(pro.getProductName());
            display.setDescription(pro.getDescription());
            display.setCategoryName(pro.getCategoryName());
            display.setQuantityStatus(pro.getQuantityStatus());
            display.setLinkProductImage(IMAGE_PRODUCT + pro.getProductImage());

            resultData.add(display);
        }

        return resultData;
    }
}
