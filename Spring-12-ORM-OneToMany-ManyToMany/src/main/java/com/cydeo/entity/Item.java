package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "items")
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;

    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }
    @ManyToMany(mappedBy = "itemList")
    private List<Cart> cart;


}
