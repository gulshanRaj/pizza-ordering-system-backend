package com.order.pizza.status;

import java.util.List;

public class StatusProvider {
    private HealthLevel healthLevel;
    private List<StatusComponent> components;

    public StatusProvider(List<StatusComponent> components) {
        this.components = components;
        updateStatus();
    }

    public HealthLevel getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(HealthLevel healthLevel) {
        this.healthLevel = healthLevel;
    }

    public List<StatusComponent> getComponents() {
        return components;
    }

    public void setComponents(List<StatusComponent> components) {
        this.components = components;
    }

    public Status updateStatus() {
        // refresh status for each component. If status of any component is error,
        // set health level as error
        if (components.stream().anyMatch(x -> x.getHealth() == HealthLevel.ERROR)) {
            this.healthLevel = HealthLevel.ERROR;
        } else {
            this.healthLevel = HealthLevel.OK;
        }
        return new Status(healthLevel, components);
    }
}
