package com.cydeo.entity;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //since entry is manual we will not add Generated value
    private Long id;
}
