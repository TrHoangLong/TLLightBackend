package com.example.backend.admin.dao;

import com.example.common.base.Cred;
import com.example.common.domain.Token;

public interface ITokenDao {
    String get(String token) throws Exception;
    void insert(String token) throws Exception;
    void delete(String token) throws Exception;
}
