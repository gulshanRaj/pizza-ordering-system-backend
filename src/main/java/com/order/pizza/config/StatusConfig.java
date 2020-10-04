package com.order.pizza.config;

import com.order.pizza.status.Status;
import com.order.pizza.status.StatusComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StatusConfig {
    @Bean
    public Status status(List<StatusComponent> components) {
        return new Status(components);
    }
}
