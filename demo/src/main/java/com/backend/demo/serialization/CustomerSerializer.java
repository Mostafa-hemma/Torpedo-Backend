package com.backend.demo.serialization;

import com.backend.demo.entity.Customer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class CustomerSerializer extends StdSerializer<Customer> {

    public CustomerSerializer() {
        this(null);
    }

    public CustomerSerializer(Class<Customer> t) {
        super(t);
    }

    @Override
    public void serialize(Customer customer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", customer.getId());
        jsonGenerator.writeStringField("name", customer.getName());
        jsonGenerator.writeNumberField("phoneNumber", customer.getPhoneNumber());
        jsonGenerator.writeStringField("role", customer.getRole());
        // Do not include the password field
        jsonGenerator.writeEndObject();
    }
}

