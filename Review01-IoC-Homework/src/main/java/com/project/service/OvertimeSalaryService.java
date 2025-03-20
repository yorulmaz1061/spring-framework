package com.project.service;

import com.project.repository.EmployeeRepository;
import com.project.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OvertimeSalaryService {
    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;
// What is the point of @Qualifier
    public OvertimeSalaryService(EmployeeRepository employeeRepository, @Qualifier("OTH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }
    public void calculateOvertimeSalary(){
        System.out.println(employeeRepository.getHourlyRate()*hoursRepository.getHours());
    }

}
