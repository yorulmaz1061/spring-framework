package com.cydeo.client;

import com.cydeo.dto.Employee;
import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url="https://dummyapi.io", name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {
    @GetMapping("/data/v1/user?limit=10")
    //Where is this specific employee
    Employee getEmployee(@RequestHeader("app-id") String id);


}
