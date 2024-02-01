package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

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
    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApi(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id", "6298ebfecd0551211fce37a6");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        //exchange is used if you want to pass something
        ResponseEntity<Object> response =restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity, Object.class);
return response;
    }




}
