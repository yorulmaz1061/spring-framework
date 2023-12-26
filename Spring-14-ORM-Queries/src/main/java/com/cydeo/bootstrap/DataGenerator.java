package com.cydeo.bootstrap;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------REGION START--------------");
        System.out.println("find by country: " + regionRepository.findByCountry("Canada"));
        System.out.println("Display all regions in Canada, without duplicates"+  regionRepository.findDistinctTopByCountry("Canada"));
        System.out.println("display all regions with country name includes 'United'"+regionRepository.findByCountryContains("United"));
        System.out.println("findByCountryContainsOrderByCountry" + regionRepository.findByCountryContainsOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("---------REGION END--------------");
        System.out.println("--------------DEPARTMENT START----------");
        System.out.println( "findByDepartment"+ departmentRepository.findByDepartment("Toys"));
        System.out.println( "findByDivisionIs"+departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContaining"+departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));
        System.out.println("--------------DEPARTMENT END----------");
        System.out.println("--------------EMPLOYEE START----------");



        System.out.println("--------------EMPLOYEE END----------");






    }
}
