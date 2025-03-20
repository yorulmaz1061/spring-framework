package com.project.service;

import com.project.repository.EmployeeRepository;
import com.project.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//For component annotation if class has a dependency or dependency itself
@Component
public class SalaryService {
    //Dependency injection
    private final EmployeeRepository employeeRepository;
    private final HoursRepository hoursRepository;

    //Constructor injection implicitly @Autowired
    // What is the point of @Qualifier?
    public SalaryService(EmployeeRepository employeeRepository, @Qualifier("RH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary() {
        System.out.println(hoursRepository.getHours() * employeeRepository.getHourlyRate());

    }

}


