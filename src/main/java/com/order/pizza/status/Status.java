package com.order.pizza.status;

import java.util.List;

public class Status {
    private HealthLevel healthLevel;
    private List<StatusComponent> components;

    public Status(HealthLevel healthLevel, List<StatusComponent> components) {
        this.healthLevel = healthLevel;
        this.components = components;
    }

    public HealthLevel getHealthLevel() {
        return healthLevel;
    }

    public List<StatusComponent> getComponents() {
        return components;
    }
}
