package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest {
    //Now get mockMvc bean
    @Autowired
    private MockMvc mvc;

    @Test
    void welcome() throws Exception {
        // steps: 1.call welcome endpoint, 2. verify "welcome"
        //Style 1. Create fake request:
        //inside get() put endpoints
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
        //There needs to be execution to send this request.
        //There is perform() method coming from mockmvc.It returns results
        MvcResult result = mvc.perform(request).andReturn();
        //Make your assertions after getting results
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("welcome", result.getResponse().getContentAsString());

    }
    //2nd way of creating test above:
    @Test
    void welcome2() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
        // in this phase we will use andExpect() method and make testi in one shot.
        // Look at method andExpect()!!
        //status() is imported MockmvcResultMatchers (look at above)
        // finish with return
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();

    }


}