package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="department_table")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
