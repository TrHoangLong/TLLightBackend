package com.example.backend.customer.dao.impl;

import com.example.backend.auth.hash.MD5HashServiceImpl;
import com.example.backend.customer.dao.ICustomerUserCustDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.domain.cust.CustomerUser;
import com.example.common.domain.sys.SysUser;
import com.example.common.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomerUserCustDaoImpl implements ICustomerUserCustDao {

    private JdbcTemplate jdbcTemplate;

    public CustomerUserCustDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private MD5HashServiceImpl md5HashService;

    @Override
    public CustomerUser getByUserEmail(Cred cred, String email) throws Exception {
        CustomerUser customerUser = new CustomerUser();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustomerUserGetByEmail").returningResultSet("CustomerUser", BeanPropertyRowMapper.newInstance(CustomerUser.class));
            params.addValue("Email", email);

            Map<String, Object> out = simpleJdbcCall.execute(params);

            List<CustomerUser> custUsers = (List<CustomerUser>) out.get("CustomerUser");

            if (custUsers.size() > 0) {
                customerUser = custUsers.get(0);
            }
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return customerUser;
    }

    @Override
    public String insert(CustomerUser user) throws Exception {
        String custUserId = "";
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustomerUserInsert");
            params.addValue("UserId", "")
                    .addValue("Password", md5HashService.hashMD5(user.getPassword()))
                    .addValue("CustName", user.getCustName())
                    .addValue("Gender", user.getGender())
                    .addValue("Birthday", DateTimeUtils.toSqlDate(user.getBirthday()))
                    .addValue("MobileNo", user.getMobileNo())
                    .addValue("Email", user.getEmail())
                    .addValue("Address", user.getAddress())
                    .addValue("Remarks", "KH đăng ký tài khoản");

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

            simpleJdbcCall.withProcedureName("CustomerUserUpdateByCust");
            params.addValue("UserId", cred.getUserId())
                    .addValue("CustName", user.getCustName())
                    .addValue("Gender", user.getGender())
                    .addValue("Birthday", DateTimeUtils.toSqlDate(user.getBirthday()))
                    .addValue("MobileNo", user.getMobileNo())
                    .addValue("Email", user.getEmail())
                    .addValue("Address", user.getAddress())
                    .addValue("Remarks", user.getRemarks());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public CustomerUser getByUserId(Cred cred,  CustomerUser user) throws Exception {
        CustomerUser customerUser = new CustomerUser();

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("CustomerUserGetById").returningResultSet("CustomerUser", BeanPropertyRowMapper.newInstance(CustomerUser.class));
            params.addValue("UserId", cred.getUserId());

            Map<String, Object> out = simpleJdbcCall.execute(params);

            List<CustomerUser> custUsers = (List<CustomerUser>) out.get("CustomerUser");

            if (custUsers.size() > 0) {
                customerUser = custUsers.get(0);
            }
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return customerUser;
    }
}
