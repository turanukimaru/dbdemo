package com.example.dbdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childId;
    @Column
    private String name;
    @Column
    private String text;
    @Column(name = "dummy_id")
    private Long dummyId;
}
