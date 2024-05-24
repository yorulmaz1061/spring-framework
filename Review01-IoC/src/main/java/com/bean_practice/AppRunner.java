package com.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class,AppConfig2.class);
        FullTimeEmployee fullTimeEmployee = context.getBean(FullTimeEmployee.class);
        PartTimeEmployee partTimeEmployee = context.getBean(PartTimeEmployee.class);
        fullTimeEmployee.createAccount();
        partTimeEmployee.createAccount();
        //since Sting is not our Class you can specify default bean name or custom bean name if you put.
        String s1 = context.getBean("str1",String.class);
        System.out.println(s1);
        String s2 = context.getBean("string2", String.class);
        System.out.println(s2);


    }

}
