package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {
    //Display all Departments in the furniture department
    List<Department> findByDepartment(String department);
    //Display all Departments in the Health Division
    List<Department> findByDivisionIs(String department);
    //This is the same query: List<Department> findByDivisionEquals(String department);
    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);

}
