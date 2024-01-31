package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {
    //provide URI which URI will bew consumed
    private final String URI = "https://jsonplaceholder.typicode.com/users";
    //Rest Template injection
    private final RestTemplate  restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    //If you consume something the nyou use @Getmapping not postmapping
    //now I am building my own API. retun me all list of users
    // which is going to come from 3rd party API
    @GetMapping
    public User[] readAllUsers(){
        //it requires source URI and target where to map as a dto.
        //it requires target as an array which is old style.
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);

        return responseEntity.getBody();

    }
    @GetMapping("{id}")
    // That is my endpoint.
    public Object readUser(@PathVariable("id") Integer id){
    // What is the differences from above?
        //  In getForObject there is no mapping, it retrives data and leave it to your end point.
        // URL will change because of path variable
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL, Object.class,id);
    }



}
