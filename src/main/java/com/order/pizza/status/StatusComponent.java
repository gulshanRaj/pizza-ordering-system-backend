package com.order.pizza.status;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface StatusComponent {
    @JsonIgnore
    HealthLevel getHealth();
}
