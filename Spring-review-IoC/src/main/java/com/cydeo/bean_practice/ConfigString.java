package com.cydeo.bean_practice;

import org.springframework.context.annotation.Bean;

public class ConfigString {
    @Bean (name = "a")
    String str(){
        return "Welcome to Cydeo";
    }
    @Bean (name = "b")
    String str2(){
        return "Spring Core Practice";
    }

}
