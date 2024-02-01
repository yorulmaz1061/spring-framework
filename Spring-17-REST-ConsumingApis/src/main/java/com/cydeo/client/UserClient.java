package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url= "https://jsonplaceholder.typicode.com/", name = "USER-CLIENT")
public interface UserClient {
    //when I call getUsers method it is gonna to UR in base URL and add endpoint
    // and whatever result is coming will be returned to method returning.
    @GetMapping("/users")
    List<User> getUsers();




}
