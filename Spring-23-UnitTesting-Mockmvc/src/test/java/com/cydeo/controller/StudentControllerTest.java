package com.cydeo.controller;

import com.cydeo.entity.Student;
import com.cydeo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void getStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(("{\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20}")))
                .andReturn();


    }

    @Test
    void jsonAssert() throws Exception {
        String expected = "\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20";
        String actual = "\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20";
        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    void getStudent_service() throws Exception {
        when(studentService.getStudent()).thenReturn(Arrays.asList(new Student("Mike", "Smith", 20)
        ,new Student("Ozan","Yorulmaz",46)));
        mockMvc.perform(MockMvcRequestBuilders.get("/service/student")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20},{\"id\": 0, \"firstName\": \"Ozan\", \"lastName\": \"Yorulmaz\", \"age\": 46}]"))
        .andReturn();

    }

}