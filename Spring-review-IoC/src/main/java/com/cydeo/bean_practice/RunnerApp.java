package com.cydeo.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunnerApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigString.class);

        //Alt + Enter + Enter
        FullTimeEmployee fe = container.getBean(FullTimeEmployee.class);
        fe.createAccount();

        PartTimeEmployee pe = container.getBean(PartTimeEmployee.class);

        pe.createAccount();

        String str=container.getBean("a",String.class);
        String str1=container.getBean("b", String.class);
        System.out.println(str);
        System.out.println(str1);

    }
}
