package com.example.common.domain;

import java.io.Serializable;
import java.util.Date;

public class Token implements Serializable {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
