package com.backend.demo.serialization;

import com.backend.demo.entity.Customer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomerIdSerializer extends StdSerializer<Customer> {

    public CustomerIdSerializer() {
        this(null);
    }

    public CustomerIdSerializer(Class<Customer> t) {
        super(t);
    }

    @Override
    public void serialize(Customer customer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(customer.getId());
    }
}
