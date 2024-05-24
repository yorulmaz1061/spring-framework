package com.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //Take this object and put it inside the container
    @Bean
    FullTimeEmployee fullTimeEmployee() {
        return new FullTimeEmployee();
    }

    @Bean
    PartTimeEmployee partTimeEmployee() {
        return new PartTimeEmployee();
    }

}
