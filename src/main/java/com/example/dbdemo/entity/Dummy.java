package com.example.dbdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Dummy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DummyId;
    @Column
    private String name;
    @Column
    private String text;
    @Column
    private String comment;

    @OneToMany(targetEntity = Child.class)
    @JoinColumn(name = "dummy_id")
    private List<Child> childList;

    public Dummy() {
    }

    public Dummy(String name, String text, String comment) {
        this.name = name;
        this.text = text;
        this.comment = comment;
    }
}
