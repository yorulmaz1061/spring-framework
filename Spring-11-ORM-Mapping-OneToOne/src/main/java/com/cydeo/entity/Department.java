package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Department extends BaseEntity{
    private String department;
    private String division;

    @OneToOne(mappedBy = "department")
    //this department name has to be matched with what ever you put it in Employee class field
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
