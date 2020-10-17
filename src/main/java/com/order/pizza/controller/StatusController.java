package com.order.pizza.controller;

import com.order.pizza.status.Status;
import com.order.pizza.status.StatusProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    private final StatusProvider status;

    public StatusController(StatusProvider status) {
        this.status = status;
    }

    @GetMapping("/status")
    public Status getStatus() {
        return status.updateStatus();
    }
}
