package com.example.backend.admin.dao.impl.cust;

import com.example.backend.admin.dao.ICustOrdersDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustOrders;
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
public class CustOrdersDaoImpl implements ICustOrdersDao {

    private JdbcTemplate jdbcTemplate;

    public CustOrdersDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CustOrders> get(Cred cred, CustOrders custOrders) throws Exception {
        List<CustOrders> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustOrdersGet")
                    .returningResultSet("CustOrders", BeanPropertyRowMapper.newInstance(CustOrders.class));
            params.addValue("UserId", cred.getUserId());
            params.addValue("CustUserId", custOrders.getCustUserId() == null ? "" : custOrders.getCustUserId());
            params.addValue("ProductId", custOrders.getProductId() == null ? "" : custOrders.getProductId());
            params.addValue("OrderStatus", custOrders.getOrderStatus() == null ? 0 :custOrders.getOrderStatus());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            List<CustOrders> custOrdersList = (List<CustOrders>) out.get("CustOrders");

            if (custOrdersList != null && custOrdersList.size() > 0) {
                resultData = custOrdersList;
            }

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return resultData;
    }

    @Override
    public void updateStatus(Cred cred, CustOrders custOrders) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustOrdersUpdateStatus");
            params.addValue("UserId", cred.getUserId());
            params.addValue("CustOrderDate", DateTimeUtils.toSqlDate(custOrders.getCustOrderDate()));
            params.addValue("CustOrderId", custOrders.getCustOrderId());
            params.addValue("OrderStatus", custOrders.getOrderStatus());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void cancel(Cred cred, CustOrders custOrders) throws Exception {
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

    @Override
    public void cancelConfirm(Cred cred, CustOrders custOrders) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustOrdersCancelConfirm");
            params.addValue("UserId", cred.getUserId());
            params.addValue("CustOrderDate", DateTimeUtils.toSqlDate(custOrders.getCustOrderDate()));
            params.addValue("CustOrderId", custOrders.getCustOrderId());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public List<CustOrders> getHist(Cred cred, CustOrders custOrders) throws Exception {
        List<CustOrders> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustOrdersHistGet")
                    .returningResultSet("CustOrders", BeanPropertyRowMapper.newInstance(CustOrders.class));
            params.addValue("UserId", cred.getUserId());
            params.addValue("CustOrderDate", custOrders.getCustOrderDate() == null ? null : custOrders.getCustOrderDate());
            params.addValue("CustUserId", custOrders.getCustUserId() == null ? "" : custOrders.getCustUserId());
            params.addValue("ProductId", custOrders.getProductId() == null ? "" : custOrders.getProductId());
            params.addValue("OrderStatus", custOrders.getOrderStatus() == null ? 0 :custOrders.getOrderStatus());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            List<CustOrders> custOrdersList = (List<CustOrders>) out.get("CustOrders");

            if (custOrdersList != null && custOrdersList.size() > 0) {
                resultData = custOrdersList;
            }

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return resultData;
    }
}
