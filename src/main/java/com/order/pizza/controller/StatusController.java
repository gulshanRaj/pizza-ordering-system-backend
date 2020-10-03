package com.order.pizza.controller;

import com.order.pizza.status.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    private final Status status;

    public StatusController(Status status) {
        this.status = status;
    }

    @GetMapping("/status")
    public Status getStatus() {
        status.updateStatus();
        return status;
    }
}
