package com.example.backend.admin.dao.impl.sys;

import com.example.backend.admin.dao.ISysCartDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.sys.SysCart;
import com.example.common.domain.sys.SysOrder;
import com.example.common.domain.sys.SysUser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SysCartDaoImpl implements ISysCartDao {

    private JdbcTemplate jdbcTemplate;

    public SysCartDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<SysCart> get(Cred cred, SysCart obj) throws Exception {
        List<SysCart> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysCartGet")
                    .returningResultSet("SysCart", BeanPropertyRowMapper.newInstance(SysCart.class));
            params.addValue("SysUserId", obj.getSysUserId() == null ? "" : obj.getSysUserId());
            params.addValue("ProductId", obj.getProductId() == null ? "" :obj.getProductId());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            List<SysCart> listCart = (List<SysCart>) out.get("SysCart");

            if(listCart != null) {
                resultData = listCart;
            }
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
        return resultData;
    }

    @Override
    public void insert(Cred cred, SysCart obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysCartInsert");
            params.addValue("SysUserId", cred.getUserId());
            params.addValue("ProductId", obj.getProductId());
            params.addValue("Quantity", obj.getQuantity());
            params.addValue("ProductPrice", obj.getProductPrice());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void update(Cred cred, SysCart obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysCartUpdate");
            params.addValue("SysCardId", obj.getSysCartID());
            params.addValue("SysUserId", cred.getUserId());
            params.addValue("ProductId", obj.getProductId());
            params.addValue("Quantity", obj.getQuantity());
            params.addValue("ProductPrice", obj.getProductPrice());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void delete(Cred cred, SysCart obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysCartDelete");
            params.addValue("SysCardId", obj.getSysCartID());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void order(Cred cred, SysOrder obj) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SysCartOrder");
            params.addValue("SysUserId", cred.getUserId());
            params.addValue("CustName", obj.getCustName());
            params.addValue("MobileNo", obj.getMobileNo());
            params.addValue("Address", obj.getAddress());
            params.addValue("ProductId", obj.getProductId());
            params.addValue("Quantity", obj.getQuantity());
            params.addValue("ProductPrice", obj.getProductPrice());
            params.addValue("IsSysOrder", true);
            params.addValue("SysCartId", obj.getSysCartID());

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
