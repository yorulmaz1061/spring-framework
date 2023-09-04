package com.cydeo.stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class ExtraHours {
    public Integer getHours(){
        return 10;
    }
}
