package com.stereotype_annotation;

import com.stereotype_annotation.config.ConfigCourse;
import com.stereotype_annotation.model.DataStructure;
import com.stereotype_annotation.model.ExtraHours;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCourse.class);
        DataStructure bean = context.getBean(DataStructure.class);



        bean.getTotalHours();
    }
}
