package com.example.backend.admin.dao.impl.product;

import com.example.backend.admin.dao.IProductCategoriesDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.product.ProductCategories;
import com.example.common.domain.sys.SysUser;
import com.example.common.utils.DateTimeUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductCategoriesDaoImpl implements IProductCategoriesDao {
    private JdbcTemplate jdbcTemplate;

    public ProductCategoriesDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductCategories> getlist(Cred cred, ProductCategories productCategories) throws Exception {
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

    @Override
    public void insert(Cred cred, ProductCategories productCategories) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("ProductCategoriesInsert");
            params.addValue("UserId", cred.getUserId());
            params.addValue("CategoryId", productCategories.getCategoryId());
            params.addValue("CategoryName", productCategories.getCategoryName());
            params.addValue("Status", productCategories.getStatus());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void update(Cred cred, ProductCategories productCategories) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("ProductCategoriesUpdate");
            params.addValue("UserId", cred.getUserId());
            params.addValue("CategoryId", productCategories.getCategoryId());
            params.addValue("CategoryName", productCategories.getCategoryName());
            params.addValue("Status", productCategories.getStatus());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
