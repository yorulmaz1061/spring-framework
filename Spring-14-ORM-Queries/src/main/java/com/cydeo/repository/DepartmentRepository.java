package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {
    //Display all Departments in the furniture department
    List<Department> findByDepartment(String department);
    //Display all Departments in the Health Division
    List<Department> findByDivisionIs(String department);
    //This is the same query: List<Department> findByDivisionEquals(String department);
    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);

    //JPQL Examples on Department
    @Query("select d FROM Department d where d.division IN ?1")
    List<Department> getDepartmentDivision(List<String>division);


    //Named queries-property example
    List<Department>retrieveDepartmentByDivision(String division);
    //Named queries-property example 2.. If you use native query in
    //named.queries.properties file you should use @Query
    @Query(nativeQuery = true)
    List<Department>retrieveDepartmentByDivisionContain(String pattern);

}
