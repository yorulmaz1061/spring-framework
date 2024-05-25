package com.project;

import com.project.config.Config;
import com.project.service.OvertimeSalaryService;
import com.project.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunnerApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SalaryService salary = context.getBean(SalaryService.class);
        salary.calculateRegularSalary();

        OvertimeSalaryService overtimeSalaryService = context.getBean(OvertimeSalaryService.class);
        overtimeSalaryService.calculateOvertimeSalary();


    }
}
