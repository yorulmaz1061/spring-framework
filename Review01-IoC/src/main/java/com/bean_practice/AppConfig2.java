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
    //You can give specific bean name like below "string2"
    @Bean("string2")
    public String str2(){
        return "Spring core practice";
    }

}

