package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Data

public class Region extends BaseEntity{
    private String region;
    private String country;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
    @OneToOne(mappedBy = "region")
    private Employee employee;

}
