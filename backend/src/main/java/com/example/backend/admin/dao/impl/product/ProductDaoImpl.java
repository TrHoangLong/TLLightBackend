package com.example.backend.admin.dao.impl.product;

import com.example.backend.admin.dao.IProductDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
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
public class ProductDaoImpl implements IProductDao {

    private JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getList(Cred cred, Product obj) throws Exception {
        List<Product> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("ProductGet")
                    .returningResultSet("Product", BeanPropertyRowMapper.newInstance(Product.class));
            params.addValue("ProductId", obj.getProductId() == null ? "" : obj.getProductId());
            params.addValue("CategoryId", obj.getCategoryId() == null ? "" : obj.getCategoryId());
            params.addValue("Status", obj.getStatus() == null ? 0 : obj.getStatus());
            params.addValue("Offset", obj.getOffset() == null ? 0 : obj.getOffset());
            params.addValue("Limit", obj.getLimit() == null ? 8 : obj.getLimit());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            List<Product> listProduct = (List<Product>) out.get("Product");

            if(listProduct != null && listProduct.size() > 0) {
                resultData = listProduct;
            }
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
        return resultData;
    }

    @Override
    public void insert(Cred cred, Product obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("ProductInsert");
            params.addValue("UserId", cred.getUserId());
            params.addValue("ProductId", obj.getProductId());
            params.addValue("CategoryId", obj.getCategoryId());
            params.addValue("ProductName", obj.getProductName());
            params.addValue("ProductPrice", obj.getProductPrice());
            params.addValue("Description", obj.getDescription());
            params.addValue("Quantity", obj.getQuantity());
            params.addValue("ProductImage", obj.getProductImage());
            params.addValue("Status", obj.getStatus());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void update(Cred cred, Product obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("ProductUpdate");
            params.addValue("UserId", cred.getUserId());
            params.addValue("ProductId", obj.getProductId());
            params.addValue("CategoryId", obj.getCategoryId());
            params.addValue("ProductName", obj.getProductName());
            params.addValue("ProductPrice", obj.getProductPrice());
            params.addValue("Description", obj.getDescription());
            params.addValue("Quantity", obj.getQuantity());
            params.addValue("ProductImage", obj.getProductImage());
            params.addValue("Status", obj.getStatus());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
