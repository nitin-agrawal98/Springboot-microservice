package com.microservice.department_service.model;

public class Employee {
    private final Long id;
    private String name;
    private Long deptId;

    public Employee(Long id, String name, Long deptId) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
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

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
