package com.example.backend.admin.dao.impl.token;

import com.example.backend.admin.dao.ITokenDao;
import com.example.backend.global.Utils;
import com.example.common.domain.Token;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TokenDaoImpl implements ITokenDao {

    private JdbcTemplate jdbcTemplate;

    public TokenDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String get(String token) throws Exception {
        String result = "";

        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("TokenGet")
                    .returningResultSet("Token", BeanPropertyRowMapper.newInstance(Token.class));
            params.addValue("Token", token);

            Map<String, Object> out = simpleJdbcCall.execute(params);

            List<Token> token1 = (List<Token>) out.get("Token");
            if (token1.size() > 0)
                result = token1.get(0).getToken();
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }

        return result;
    }

    @Override
    public void insert(String token) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("TokenInsert");
            params.addValue("Token", token);

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }

    @Override
    public void delete(String token) throws Exception {
        try {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
            MapSqlParameterSource params = new MapSqlParameterSource();

            simpleJdbcCall.withProcedureName("TokenDelete");
            params.addValue("Token", token);

            simpleJdbcCall.execute(params);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
