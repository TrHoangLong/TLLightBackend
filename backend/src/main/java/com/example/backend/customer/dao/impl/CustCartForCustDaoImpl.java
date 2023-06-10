package com.example.backend.customer.dao.impl;

import com.example.backend.customer.dao.ICustCartForCustDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustomerUser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustCartForCustDaoImpl implements ICustCartForCustDao {

    private JdbcTemplate jdbcTemplate;

    public CustCartForCustDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CustCart> get(Cred cred, CustCart obj) throws Exception {
        List<CustCart> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustCartGetForcust")
                    .returningResultSet("CustCart", BeanPropertyRowMapper.newInstance(CustCart.class));
            params.addValue("UserId", cred.getUserId());

            Map<String, Object> out = simpleJdbcCall.execute(params);

            List<CustCart> custCartList = (List<CustCart>) out.get("CustCart");

            if (custCartList.size() > 0) {
                resultData = custCartList;
            }

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return resultData;
    }

    @Override
    public void insert(Cred cred, CustCart obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustCartInsert");
            params.addValue("UserId", cred.getUserId());
            params.addValue("ProductId", obj.getProductId());
            params.addValue("Quantity", obj.getQuantity());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void update(Cred cred, CustCart obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustCartUpdate");
            params.addValue("UserId", cred.getUserId());
            params.addValue("CustCartId", obj.getCustCartId());
            params.addValue("Quantity", obj.getQuantity());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void delete(Cred cred, CustCart obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustCartDelete");
            params.addValue("UserId", cred.getUserId());
            params.addValue("CustCartId", obj.getCustCartId());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
