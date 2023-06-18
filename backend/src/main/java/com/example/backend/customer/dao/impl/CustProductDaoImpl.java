package com.example.backend.customer.dao.impl;

import com.example.backend.customer.dao.ICustProductDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.product.Product;
import com.example.common.domain.product.ProductCategories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustProductDaoImpl implements ICustProductDao {

    private JdbcTemplate jdbcTemplate;

    public CustProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getList(Cred cred, Product product) throws Exception {
        List<Product> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("ProductGetForCust").returningResultSet("Product", BeanPropertyRowMapper.newInstance(Product.class));
            params.addValue("UserId", cred.getUserId());
            params.addValue("ProductId", product.getProductId() == null ? "" : product.getProductId());
            params.addValue("CategoryId", product.getCategoryId() == null ? "" : product.getCategoryId());
            params.addValue("Offset", product.getOffset() == null ? 0 : product.getOffset());
            params.addValue("Limit", product.getLimit() == null ? 8 : product.getLimit());

            Map<String, Object> out = simpleJdbcCall.execute(params);

            List<Product> custUsers = (List<Product>) out.get("Product");

            if (custUsers.size() > 0) {
                resultData = custUsers;
            }
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return resultData;
    }

    @Override
    public List<ProductCategories> getCategories(Cred cred, ProductCategories productCategories) throws Exception {
        List<ProductCategories> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("ProductCategoriesGet")
                    .returningResultSet("ProductCategories", BeanPropertyRowMapper.newInstance(ProductCategories.class));
            params.addValue("UserId", cred.getUserId())
                    .addValue("CategoryId", productCategories.getCategoryId() == null ? "" : productCategories.getCategoryId())
                    .addValue("Status", productCategories.getStatus() == null ? 0 : productCategories.getStatus());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            List<ProductCategories> listCategories = (List<ProductCategories>) out.get("ProductCategories");

            if(listCategories != null && listCategories.size() > 0) {
                resultData = listCategories;
            }
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
        return resultData;
    }
}
