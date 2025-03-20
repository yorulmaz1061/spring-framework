package com.stereotype_annotation.model;

import org.springframework.stereotype.Component;

@Component
//If the class has a dependency or it is a dependency itself we need @Component
public class ExtraHours {

    public Integer getExtraHours(){
        return 10;
    }
}
