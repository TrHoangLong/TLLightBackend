package com.example.backend.global;import com.example.common.base.GTException;import org.springframework.stereotype.Component;import org.springframework.dao.*;import java.util.Arrays;@Componentpublic class Utils {    public static GTException processException(Exception ex) {        String [] message = null;        if (ex.getMessage() != null) {            message = ex.getCause().getMessage().split(";");        } else {            message = new String[]{"Lỗi hệ thống"};        }        return getException(message);    }    private static GTException getException(String [] message) {        String code = message[0];        String [] params = Arrays.copyOfRange(message, 1, message.length);        return new GTException(code, null, params);    }}