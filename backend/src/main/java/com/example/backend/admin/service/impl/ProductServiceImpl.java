package com.example.backend.admin.service.impl;

import com.example.backend.admin.dao.IProductDao;
import com.example.backend.admin.dao.IProductCategoriesDao;
import com.example.backend.admin.service.IProductService;
import com.example.backend.global.FileUploadUtils;
import com.example.common.base.Cred;
import com.example.common.base.GTException;
import com.example.common.domain.product.Product;
import com.example.common.domain.product.ProductCategories;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductCategoriesDao productCategoriesDao;

    @Autowired
    private IProductDao productDao;

    @Value("${image.config.imageProduct-dir}")
    private String IMAGE_PRODUCT_DIR;

    @Value("${image.config.imageProduct}")
    private String IMAGE_PRODUCT;

    //==========================ProductCategories===================================//
    @Override
    public List<ProductCategories> productCategoriesGet(Cred cred, ProductCategories productGroup) throws Exception {
        return productCategoriesDao.getlist(cred, productGroup);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void productCategoriesInsert(Cred cred, ProductCategories productGroup) throws Exception {

        if (cred.getRole() != 2 && cred.getRole() != 1) {
            throw new GTException("Tài khoản không đủ quyền để thực hiện hành động này", null, null);
        }

        productCategoriesDao.insert(cred, productGroup);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void productCategoriesUpdate(Cred cred, ProductCategories productGroup) throws Exception {

        if (cred.getRole() != 2 && cred.getRole() != 1) {
            throw new GTException("Tài khoản không đủ quyền để thực hiện hành động này", null, null);
        }

        productCategoriesDao.update(cred, productGroup);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void productCategoriesInsertExcel(Cred cred, List<ProductCategories> categoriesList) throws Exception {

        if (cred.getRole() != 2 && cred.getRole() != 1) {
            throw new GTException("Tài khoản không đủ quyền để thực hiện hành động này", null, null);
        }

        for (ProductCategories categories : categoriesList) {
            productCategoriesDao.insert(cred, categories);
        }
    }


    //==========================Product===========================================//
    @Override
    public List<Product> productGet(Cred cred, Product product) throws Exception {
        List<Product> listProductResult = new ArrayList<>();

        for(Product prd : productDao.getList(cred, product)) {
            String linkImageProduct = IMAGE_PRODUCT + prd.getProductImage();
            prd.setLinkProductImage(linkImageProduct);
            listProductResult.add(prd);
        }

        return listProductResult;
    }

    @Override
    public Product productReload(Cred cred, Product product) throws Exception {
        List<Product> listProduct = productDao.getList(cred, product);
        String linkImageProduct = "";
        Product productResult = new Product();

        if (listProduct.size() > 0) {
            productResult = listProduct.get(0);
            linkImageProduct = IMAGE_PRODUCT + productResult.getProductImage();
        }
        productResult.setLinkProductImage(linkImageProduct);

        return productResult;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void productInsert(Cred cred, HttpServletRequest request) throws Exception {

        if (cred.getRole() != 2 && cred.getRole() != 1) {
            throw new GTException("Tài khoản không đủ quyền để thực hiện hành động này", null, null);
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String info = request.getParameter("info");

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(info, Product.class);

        MultipartFile imageProduct = multipartRequest.getFile("imageProduct");
        if (imageProduct != null) {
            UUID uuid = UUID.randomUUID();
            FileUploadUtils.saveFile(IMAGE_PRODUCT_DIR, uuid.toString(), imageProduct);
            product.setProductImage(uuid.toString());
        }

        productDao.insert(cred, product);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void productUpdate(Cred cred, HttpServletRequest request) throws Exception {

        if (cred.getRole() != 2 && cred.getRole() != 1) {
            throw new GTException("Tài khoản không đủ quyền để thực hiện hành động này", null, null);
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String info = request.getParameter("info");

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(info, Product.class);

        MultipartFile imageProduct = multipartRequest.getFile("imageProduct");
        if (imageProduct != null) {
            UUID uuid = UUID.randomUUID();
            FileUploadUtils.saveFile(IMAGE_PRODUCT_DIR, uuid.toString(), imageProduct);
            product.setProductImage(uuid.toString());
        }

        productDao.update(cred, product);
    }

}
