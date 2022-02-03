package io.i15s.quarkus;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.jackson.ObjectMapperCustomizer;
import org.zalando.jackson.datatype.money.MoneyModule;

import javax.inject.Singleton;

@Singleton
public class MoneyObjectMapperCustomizer implements ObjectMapperCustomizer {

    @Override
    public void customize(ObjectMapper objectMapper) {
        objectMapper.registerModule(new MoneyModule());
    }
}
