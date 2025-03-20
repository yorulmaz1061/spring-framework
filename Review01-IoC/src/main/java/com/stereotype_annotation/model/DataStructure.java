package com.stereotype_annotation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
//Constructor Injection, field injection. Setter injection. We generally use Constructor injection
public class DataStructure {
    //We need to get dependencies (dependency injection) to use ExtraHours
    //By using @NonNull you declare that the constructor below is included requiredArg constructor.
    @NonNull
    ExtraHours extraHours;
//No need @Autowired, it makes automatically. With @Data it creates constructor
    /*  //@Autowired
      public DataStructure(ExtraHours extraHours) {
          this.extraHours = extraHours;
      }
  */
    public void getTotalHours() {
        System.out.println("Total hours " + (10 + extraHours.getExtraHours()));
    }
}
