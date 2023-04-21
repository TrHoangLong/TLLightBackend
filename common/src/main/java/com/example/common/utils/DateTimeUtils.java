package com.example.common.utils;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.*;
import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeUtils {
    public static java.sql.Date toSqlDate(Date date) {
        if (CompareUtils.isEqualsNull(date)) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
    public static java.util.Date toUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }
    public static java.sql.Date toSmallSqlDate(Date date){
        if (CompareUtils.isEqualsNull(date)) {
            return null;
        }
        try {
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
            return new java.sql.Date(sdfDate.parse(sdfDate.format(date)).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new java.sql.Date(date.getTime());
    }
}