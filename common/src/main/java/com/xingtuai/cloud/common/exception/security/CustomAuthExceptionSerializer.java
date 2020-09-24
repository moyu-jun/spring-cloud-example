package com.xingtuai.cloud.common.exception.security;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author James
 * @date 2020/9/24
 */
public class CustomAuthExceptionSerializer extends StdSerializer<CustomAuthException> {
    protected CustomAuthExceptionSerializer() {
        super(CustomAuthException.class);
    }

    @Override
    public void serialize(CustomAuthException e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(e.getResult());
    }
}
