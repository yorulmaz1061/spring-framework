package com.cydeo.repository;

import com.cydeo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //Some more JPQL Examples:
    //Not equal
    @Query("SELECT e FROM Employee e where e.salary<>?1")
    List<Employee>getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("SELECT e from Employee e where e.firstName like ?1 ")
    List<Employee>getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("SELECT e FROM Employee e WHERE e.salary<?1")
    List<Employee>getEmployeeSalaryLessThan(int salary);

    //greater than
    @Query("SELECT e FROM Employee e WHERE e.salary>?1")
    List<Employee>getEmployeeSalaryGreaterThan(int salary);

    //Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate>?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeEmailIsNull();
    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeEmailIsNotNull();
    //Sorting in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary ASC ")
    List<Employee> getEmployeeSalaryOrderAsc();
    //Sorting in descending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> getEmployeeSalaryOrderDesc();

    //Native Query sample
    @Query(value = "SELECT * FROM employees WHERE salary ?1 ", nativeQuery=true)
    List<Employee> readEmployeeDetailBySOrderBySalary(int salary);

    //JPQL named parameters
    @Query("SELECT e from Employee e WHERE e.salary=:salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    //Update Employee with JPQL
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET  e.email='admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("id") int id);

    //Update Employee with NativeQuery
    @Modifying
    @Transactional
    @Query(value="UPDATE employees  SET  email='admin@email.com' WHERE id=:id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);





























}
