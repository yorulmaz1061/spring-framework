package com.cydeo.stereotype_annotations.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
@Data
public class DataStructure {
    @NonNull
   ExtraHours extraHours;
   //no need to Autowrite

  /*  public DataStructure(ExtraHours extraHours) {
        this.extraHours = extraHours;
    }*/

    public void getTotalHours(){
        System.out.println("Total hours: " + (20 + extraHours.getHours()));
    }
}
