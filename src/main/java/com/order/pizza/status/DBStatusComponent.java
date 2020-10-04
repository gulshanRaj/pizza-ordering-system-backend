package com.order.pizza.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
public class DBStatusComponent implements StatusComponent {

    @JsonIgnore
    private final EntityManager entityManager;

    private String connection = "Not Established";
    private String name = "Postgres DB";

    public DBStatusComponent(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public HealthLevel getHealth() {
        try {
            Query q = entityManager.createNativeQuery("SELECT 1");
            int response = (int)q.getSingleResult();
            if(response == 1) {
                this.connection = "Established";
                return HealthLevel.OK;
            } else {
                this.connection = "Not Established";
                return HealthLevel.ERROR;
            }
        } catch (Exception e) {
            this.connection = "Not Established";
            return HealthLevel.ERROR;
        }
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getName() {
        return name;
    }
}
