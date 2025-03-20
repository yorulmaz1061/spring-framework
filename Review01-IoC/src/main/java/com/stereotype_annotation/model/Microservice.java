package com.stereotype_annotation.model;

import org.springframework.stereotype.Component;

@Component
public class Microservice {
    public void getTotalHours(){
        System.out.println("Total hours "+25);
    }
}
