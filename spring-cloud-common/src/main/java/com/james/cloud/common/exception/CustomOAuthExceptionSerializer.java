package com.james.cloud.common.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author James
 * @date 2020/4/26
 */
public class CustomOAuthExceptionSerializer extends StdSerializer<CustomOAuthException> {
    protected CustomOAuthExceptionSerializer() {
        super(CustomOAuthException.class);
    }

    @Override
    public void serialize(CustomOAuthException e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(e.getResult());
    }
}
