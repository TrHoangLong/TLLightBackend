package com.example.backend.customer.dao.impl;

import com.example.backend.customer.dao.ICustProductDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.product.Product;
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
}
