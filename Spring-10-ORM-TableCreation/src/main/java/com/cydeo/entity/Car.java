package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
// @AllArgsConstructor We cannot create it because id will be populated automatically
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
