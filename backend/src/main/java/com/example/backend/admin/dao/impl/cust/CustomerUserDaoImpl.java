package com.example.backend.admin.dao.impl.cust;

import com.example.backend.admin.auth.hash.MD5HashServiceImpl;
import com.example.backend.admin.dao.ICustomerUserDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.cust.CustomerUserDisplay;
import com.example.common.domain.product.Product;
import com.example.common.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerUserDaoImpl implements ICustomerUserDao {

    private JdbcTemplate jdbcTemplate;

    public CustomerUserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private MD5HashServiceImpl md5HashService;

    @Override
    public List<CustomerUserDisplay> get(Cred cred, CustomerUser user) throws Exception {
        List<CustomerUserDisplay> resultList = new ArrayList<>();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustomerUserGet")
                    .returningResultSet("CustomerUserDisplay", BeanPropertyRowMapper.newInstance(CustomerUserDisplay.class));
            params.addValue("CustUserId", user.getCustUserId() == null ? "" : user.getCustUserId())
                    .addValue("Status", user.getStatus() == null ? 0 : user.getStatus());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            List<CustomerUserDisplay> displayList = (List<CustomerUserDisplay>) out.get("CustomerUserDisplay");

            if (displayList != null && displayList.size() > 0) {
                resultList = displayList;
            }
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return resultList;
    }

    @Override
    public String insert(Cred cred, CustomerUser user) throws Exception {
        String custUserId = "";
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustomerUserInsert");
            params.addValue("UserId", cred.getUserId())
                    .addValue("Password", md5HashService.hashMD5(user.getPassword()))
                    .addValue("CustName", user.getCustName())
                    .addValue("Gender", user.getGender())
                    .addValue("Birthday", DateTimeUtils.toSqlDate(user.getBirthday()))
                    .addValue("MobileNo", user.getMobileNo())
                    .addValue("Email", user.getEmail())
                    .addValue("Address", user.getAddress())
                    .addValue("Remarks", user.getRemarks());

            Map<String, Object> out = simpleJdbcCall.execute(params);
            custUserId = (String) out.get("CustUserId");

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return custUserId;
    }

    @Override
    public void update(Cred cred, CustomerUser user) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustomerUserUpdate");
            params.addValue("UserId", cred.getUserId())
                    .addValue("CustName", user.getCustName())
                    .addValue("Gender", user.getGender())
                    .addValue("Birthday", DateTimeUtils.toSqlDate(user.getBirthday()))
                    .addValue("MobileNo", user.getMobileNo())
                    .addValue("Email", user.getEmail())
                    .addValue("Address", user.getAddress())
                    .addValue("Remarks", user.getRemarks())
                    .addValue("CustUserId", user.getCustUserId());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void delete(Cred cred, CustomerUser user) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustomerUserDelete");
            params.addValue("UserId", cred.getUserId())
                    .addValue("CustUserId", user.getCustUserId());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
