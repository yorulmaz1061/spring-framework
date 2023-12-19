package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "StudentFirstName")
    private String firstName;
    @Column(name = "StudentLastName")
    private String lastName;
    private String email;

    @Transient
    private String city;
    @Column(columnDefinition = "DATE")
    private LocalDate birthdate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
