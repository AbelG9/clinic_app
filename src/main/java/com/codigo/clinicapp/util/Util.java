package com.codigo.clinicapp.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;

public class Util {
    public static boolean isNullOrEmpty(String data) {
        return data == null || data.isEmpty();
    }
    public static Timestamp getActualTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    public static String convertToJsonEntity(Object entity) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static <T> T convertFromJson(String json, Class<T> valueType) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
