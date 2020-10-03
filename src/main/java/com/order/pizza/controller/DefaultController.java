package com.order.pizza.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class DefaultController {

    @RequestMapping("/")
    public RedirectView index() {
        return new RedirectView("/swagger-ui.html", true);
    }
}