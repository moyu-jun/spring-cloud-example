package com.xingtuai.cloud.common.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Jackson 操作封装
 *
 * @author James
 * @date 2020/9/24
 */
public class JsonUtils {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        // objectMapper.getSerializerProvider().setNullKeySerializer(new NullKeySerializer());
        // objectMapper.setDateFormat(new SimpleDateFormat(DiscoveryConstant.DATE_FORMAT));
    }

    public static class NullKeySerializer extends StdSerializer<Object> {
        private static final long serialVersionUID = -9176767187240330396L;

        public NullKeySerializer() {
            this(null);
        }

        public NullKeySerializer(Class<Object> object) {
            super(object);
        }

        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeFieldName(StringUtils.EMPTY);
        }
    }

    public static <T> String toJson(T object) {
        if (object == null) {
            throw new IllegalArgumentException("Object is null");
        }

        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            throw new IllegalArgumentException("Json is null or empty");
        }

        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(json)) {
            throw new IllegalArgumentException("Json is null or empty");
        }

        try {
            return objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
