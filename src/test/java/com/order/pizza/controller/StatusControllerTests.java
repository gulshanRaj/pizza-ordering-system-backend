package com.order.pizza.controller;

import com.order.pizza.status.HealthLevel;
import com.order.pizza.status.Status;
import com.order.pizza.status.StatusComponent;
import com.order.pizza.status.StatusProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StatusController.class)
public class StatusControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatusProvider statusProvider;

    @Test
    public void statusTest() throws Exception {
        Status s = new Status(HealthLevel.OK, Collections.singletonList(new StatusComponent() {
            public String getName() {
                return "mockComponent";
            }

            @Override
            public HealthLevel getHealth() {
                return HealthLevel.OK;
            }
        }));
        given(statusProvider.updateStatus()).willReturn(s);
        mockMvc.perform(get("/status"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'healthLevel':'OK','components':[{'name':'mockComponent'}]}"));
    }
}
