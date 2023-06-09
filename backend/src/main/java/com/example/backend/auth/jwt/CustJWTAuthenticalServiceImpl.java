package com.example.backend.auth.jwt;

import com.example.backend.admin.dao.impl.token.TokenDaoImpl;
import com.example.common.base.Cred;
import com.example.common.base.GTException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class CustJWTAuthenticalServiceImpl implements JWTAuthenticalService {
    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final String JWT_SECRET = "CUST-TL-LIGHT@2910";

    //Thời gian có hiệu lực của chuỗi jwt
    private final long JWT_EXPIRATION = 1000 * 60 * 60 * 24 * 2; // 2 day

    @Autowired
    private TokenDaoImpl tokenDao;

    @Override
    public String generateToken(Cred cred) throws Exception {
        try {
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
            String token = Jwts.builder().setSubject(cred.getUserId()).setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                    .compact();
            tokenDao.insert(token);
            return token;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Cred getCredFromJWT(String token) throws Exception {
        Cred cred = new Cred();
        String userId = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();

        cred.setUserId(userId);
        cred.setRole(4);

        if(cred == null) {
            throw new GTException("ErrToken: Không lấy được thông tin người dùng", null, null);
        }

        return cred;
    }

    @Override
    public boolean validateToken(String authToken) throws Exception {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            throw new GTException("ErrToken: Invalid token!!", null, null);
        } catch (ExpiredJwtException ex) {
            tokenDao.delete(authToken);
            throw new GTException("ErrToken: Expired jwt token!", null, null);
        } catch (UnsupportedJwtException ex) {
            throw new GTException("ErrToken: Unsupported jwt token!!", null, null);
        } catch (IllegalArgumentException ex) {
            throw new GTException("ErrToken: jwt claims string is empty", null, null);
        } catch (Exception ex) {
            throw new GTException("ErrToken: " + ex.getMessage(), null, null);
        }
    }

    @Override
    public Cred checkSession(String token) throws Exception {
        if(token == null || token == "") {
            throw new GTException("ErrToken: Hết hạn đăng nhập!!", null, null);
        }
        String tokenCheck = tokenDao.get(token);
        if (tokenCheck == null || tokenCheck == "") {
            throw new GTException("ErrToken: Hết hạn đăng nhập!!", null, null);
        }

        validateToken(token);
        Cred cred = getCredFromJWT(token);

        return cred;
    }

    @Override
    public void logout(String token) throws Exception {
        tokenDao.delete(token);
    }
}
