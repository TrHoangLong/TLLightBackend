package com.example.backend.admin.dao.impl.sys;

import com.example.backend.admin.dao.ISystemDao;
import com.example.backend.global.Utils;
import com.example.common.base.Cred;
import com.example.common.utils.DateTimeUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class SystemDaoImpl implements ISystemDao {

    private JdbcTemplate jdbcTemplate;

    public SystemDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void closeDate(Cred cred) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("SystemCloseDate");
            params.addValue("UserId", cred.getUserId());

            simpleJdbcCall.execute(params);

        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
