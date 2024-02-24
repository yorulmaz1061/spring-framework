package com.cydeo.service.impl;

import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    //It means we want to mock user repository
    @Mock
    UserRepository userRepository;
    //This is for injecting not real user service but mock one.
    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUserName_test() {
        //This section below is our test run. Others are for verifying.
        userService.deleteByUserName("mikesmith@cydeo.com");
        //Mockito.verify is coming from mockito class
        //It will mock to run delete by username method in repository
       // Mockito.verify(userRepository).deleteByUserName("mikesmith@cydeo.com");

        //Mockito.verify(userRepository, Mockito.times(2)).deleteByUserName("mikesmith@cydeo.com");

       /* //In case you need to make sure method will run at least one:
        Mockito.verify(userRepository, Mockito.atLeastOnce()).deleteByUserName("mikesmith@cydeo.com");

        //This method is gonna be executed at least 5 times
        Mockito.verify(userRepository, Mockito.atLeast(5)).deleteByUserName("mikesmith@cydeo.com");

        // This method is gonna be executed at most 5 times
        Mockito.verify(userRepository, Mockito.atMost(5)).deleteByUserName("mikesmith@cydeo.com");

        // This method is gonna be executed at most once
        Mockito.verify(userRepository, Mockito.atMostOnce()).deleteByUserName("mikesmith@cydeo.com");*/

        //You can combine methods and verify run order with InOrder interface as well:
        InOrder inOrder=Mockito.inOrder(userRepository);
        inOrder.verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
        inOrder.verify(userRepository).findAll();







    }


}