package com.example.backend.customer.dao.impl;

import com.example.backend.customer.dao.ICustOrderForCustDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustOrders;
import com.example.common.domain.cust.CustomerUser;
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
public class CustOrderForCustDaoImpl implements ICustOrderForCustDao {

    private JdbcTemplate jdbcTemplate;

    public CustOrderForCustDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void custCartOrder(Cred cred, CustOrders custOrders) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustOrderInsert");
            params.addValue("UserId", cred.getUserId())
                    .addValue("ProductId", custOrders.getProductId())
                    .addValue("Quantity", custOrders.getQuantity())
                    .addValue("MobileNo", custOrders.getMobileNo())
                    .addValue("Address", custOrders.getAddress())
                    .addValue("IsCustCartOrder", true)
                    .addValue("CustCartId", custOrders.getCustCartId());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void productOrder(Cred cred, CustOrders custOrders) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustOrderInsert");
            params.addValue("UserId", cred.getUserId())
                    .addValue("ProductId", custOrders.getProductId())
                    .addValue("Quantity", custOrders.getQuantity())
                    .addValue("MobileNo", custOrders.getMobileNo())
                    .addValue("Address", custOrders.getAddress())
                    .addValue("IsCustCartOrder", false)
                    .addValue("CustCartId", 0);

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public List<CustOrders> getList(Cred cred, CustOrders custOrders) throws Exception {
        List<CustOrders> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustOrdersGetForCust")
                    .returningResultSet("CustOrders", BeanPropertyRowMapper.newInstance(CustOrders.class));
            params.addValue("UserId", cred.getUserId());

            Map<String, Object> out = simpleJdbcCall.execute(params);

            List<CustOrders> custOrdersList = (List<CustOrders>) out.get("CustOrders");

            if (custOrdersList.size() > 0) {
                resultData = custOrdersList;
            }

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return resultData;
    }

    @Override
    public void cancelRequire(Cred cred, CustOrders custOrders) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustOrdersCancel");
            params.addValue("UserId", cred.getUserId());
            params.addValue("CustOrderDate", DateTimeUtils.toSqlDate(custOrders.getCustOrderDate()));
            params.addValue("CustOrderId", custOrders.getCustOrderId());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
