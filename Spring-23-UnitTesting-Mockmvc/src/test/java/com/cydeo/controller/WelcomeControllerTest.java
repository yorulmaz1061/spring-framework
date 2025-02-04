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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = WelcomeController.class)
class WelcomeControllerTest {

    //get MockMvc bean
    @Autowired
    private MockMvc mockMvc;
    //Style1: call /welcome end point and verify
    @Test
    void welcome() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
        //There needs to be execution to send this request.
        //There is perform() method coming from mockmvc.It returns results
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //Make your assertions after getting results
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("welcome", result.getResponse().getContentAsString());



    }
    @Test
    void welcome2() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();

    }

}