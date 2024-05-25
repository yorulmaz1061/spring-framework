package com.project.repository;

import com.project.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{
    //Assume we are getting this data from the dB
    @Override
    public int getHourlyRate() {
        Employee employee=new Employee("ozan","sales",10);
        return employee.getHourlyRate();

    }
}
