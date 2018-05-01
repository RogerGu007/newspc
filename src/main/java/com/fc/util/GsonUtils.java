package com.fc.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class GsonUtils {
    public static String toJson(Object src) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(src);
    }

    public static String toJson(Object src, String dateformat) {
        Gson gson = new GsonBuilder().setDateFormat(dateformat).create();
        return gson.toJson(src);
    }

    public static  <T> T fromJson(String json, Type typeOfT) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, typeOfT);
    }

    public static  <T> T fromJson(String json, String dateformat, Type typeOfT) {
        Gson gson = new GsonBuilder().setDateFormat(dateformat).create();
        return gson.fromJson(json, typeOfT);
    }
}
