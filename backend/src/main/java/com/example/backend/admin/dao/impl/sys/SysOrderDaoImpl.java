package com.example.backend.admin.dao.impl.sys;

import com.example.backend.admin.dao.ISysOrderDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.sys.SysCart;
import com.example.common.domain.sys.SysOrder;
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
public class SysOrderDaoImpl implements ISysOrderDao {

    private JdbcTemplate jdbcTemplate;

    public SysOrderDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SysOrder> get(Cred cred, SysOrder sysOrder) throws Exception {
        List<SysOrder> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysOrderGet")
                    .returningResultSet("SysOrder", BeanPropertyRowMapper.newInstance(SysOrder.class));
            params.addValue("SysUserId", sysOrder.getSysUserId() == null ? "" : sysOrder.getSysUserId());
            params.addValue("ProductId", sysOrder.getProductId() == null ? "" :sysOrder.getProductId());
            params.addValue("OrderStatus", sysOrder.getOrderStatus() == null ? 0 :sysOrder.getOrderStatus());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            List<SysOrder> orderList = (List<SysOrder>) out.get("SysOrder");

            if(orderList != null) {
                resultData = orderList;
            }
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
        return resultData;
    }

    @Override
    public void order(Cred cred, SysOrder sysOrder) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysCartOrder");
            params.addValue("SysUserId", cred.getUserId());
            params.addValue("CustName", sysOrder.getCustName());
            params.addValue("MobileNo", sysOrder.getMobileNo());
            params.addValue("Address", sysOrder.getAddress());
            params.addValue("ProductId", sysOrder.getProductId());
            params.addValue("Quantity", sysOrder.getQuantity());
            params.addValue("ProductPrice", sysOrder.getProductPrice());
            params.addValue("IsSysOrder", false);
            params.addValue("SysCartId", 0);

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void updateStatus(Cred cred, SysOrder sysOrder) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysOrderUpdateOrderStatus");
            params.addValue("SysUserId", cred.getUserId());
            params.addValue("SysOrderDate", DateTimeUtils.toSqlDate(sysOrder.getSysOrderDate()));
            params.addValue("SysOrderId", sysOrder.getSysOrderId());
            params.addValue("OrderStatus", sysOrder.getOrderStatus());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void cancel(Cred cred, SysOrder sysOrder) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysOrderCancel");
            params.addValue("SysUserId", cred.getUserId());
            params.addValue("SysOrderDate", DateTimeUtils.toSqlDate(sysOrder.getSysOrderDate()));
            params.addValue("SysOrderId", sysOrder.getSysOrderId());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
