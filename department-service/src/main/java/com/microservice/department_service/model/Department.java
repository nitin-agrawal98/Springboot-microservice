package com.microservice.department_service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final Long id;
    private String name;
    private List<Employee> employees;

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
