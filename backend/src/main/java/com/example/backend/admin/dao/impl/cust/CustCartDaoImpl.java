package com.example.backend.admin.dao.impl.cust;

import com.example.backend.admin.dao.ICustCartDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustCart;
import com.example.common.domain.cust.CustomerUserDisplay;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustCartDaoImpl implements ICustCartDao {

    private JdbcTemplate jdbcTemplate;

    public CustCartDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CustCart> get(Cred cred, CustCart custCart) throws Exception {
        List<CustCart> resultData = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustCartGet")
                    .returningResultSet("CustCart", BeanPropertyRowMapper.newInstance(CustCart.class));
            params.addValue("UserId", cred.getUserId());
            params.addValue("CustUserId", custCart.getCustUserId() == null ? "" : custCart.getCustUserId());
            params.addValue("Status", custCart.getStatus() == null ? 0 : custCart.getStatus());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            List<CustCart> custCartList = (List<CustCart>) out.get("CustCart");

            if (custCartList != null && custCartList.size() > 0) {
                resultData = custCartList;
            }

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return resultData;
    }
}
