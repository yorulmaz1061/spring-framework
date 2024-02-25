package com.cydeo.controller;

import com.cydeo.entity.Student;
import com.cydeo.service.StudentService;
import org.json.JSONException;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    StudentService studentService;

    @Test
    void getStudent() throws Exception {
        //now we will directly put request builders into perform method
        mvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                //this time I want to check JSON content not a basic String
                // like we did in previous test
                .andExpect(content().json("{\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20}")).andReturn();
    }

    @Test
    void jsonAssert() throws JSONException {
        String expected = "{\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\"}";
        String actual = "{\"id\": 0, \"firstName\": \"Mike\", \"lastName\": \"Smith\", \"age\": 20}";
        JSONAssert.assertEquals(expected, actual, true);
        //true/false is looking parameter strict. If you put true and parameter amount is not match it fails
        // Not so common in use.
    }

    @Test
    void getStudent_service() throws Exception {
        //we will mock studentService
        //It means that we you encounter with this method (getStudent())
        //Don't do anything but act like we gave as a list
        //By doing this we will heck if studentService.getStudent() methods works
        when(studentService.getStudent()).thenReturn(Arrays.asList(new Student("John", "Doe", 20), new Student("Tom", "Hanks", 50)));

        mvc.perform(MockMvcRequestBuilders.get("/service/student")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\": 0, \"firstName\": \"John\", \"lastName\": \"Doe\", \"age\": 20},{\"id\": 0, \"firstName\": \"Tom\", \"lastName\": \"Hanks\", \"age\": 50}]"))
                .andReturn();

    }

}



