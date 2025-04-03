package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cinema")
public class Cinema extends BaseEntity{
    private String name;
    private String sponsoredName;
    @ManyToOne(fetch = FetchType.EAGER)
    private Location location;

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", sponsoredName='" + sponsoredName + '\'' +
                '}';
    }
}
