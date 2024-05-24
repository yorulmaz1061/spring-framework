package com.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig2 {

   // @Primary
    @Bean
    public String str1(){
        return "Welcome to CydeoApp";
    }
    //@Primary
    @Bean("string2")
    public String str2(){
        return "Spring core practice";
    }

}

