package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Display all employees with email adress ' '
    List<Employee>findByEmail(String email);
    //Display all employees with first name ' ' and last name ' ' and also show all employess with an email adress
    List<Employee>findByFirstNameAndLastNameOrEmail(String firstName,String lastName, String email);
    //Display all employees that first name is not ' '
    List<Employee>findByFirstNameNot(String firstName);
    //Display all employees where last name starts with ' '
    List<Employee>findByLastNameStartsWith(String pattern);
    //Display all employees with salaries higher than ' '
    List<Employee>findBySalaryGreaterThan(Integer salary);
    //Display all employeess with salaries less than ' '
    List<Employee>findBySalaryLessThanEqual(Integer salary);
    //Display all employees that has been hired between ' ' and ' ' dates
    List<Employee>findByHireDateBetween(LocalDate startDate, LocalDate endDate);
    // Display all employees where salaries greater and equal to '' in order
    List<Employee>findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);
    //Display top unique3 employees that is making less than ' '
    List<Employee>findDistinctTop3BySalaryLessThan(Integer salary);
    //Display all employees that do not have email adress
    //I did not put any parameter
    List<Employee>findByEmailIsNull();

    //Below they are JPQL:
    @Query("Select e from Employee e where e.email='sdubber7@t-online.de'" )
    Employee getEmployeeDetail();

    @Query ("select e.salary from  Employee e where e.email='sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("SELECT  e FROM Employee e WHERE e.email=?1")
    //Since it may return null pointer exception it is with Optional structure
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e from Employee e where e.email=?1 AND e.salary=?2")
    Optional<Employee>getEmployeDetail(String email, int salary);













}
