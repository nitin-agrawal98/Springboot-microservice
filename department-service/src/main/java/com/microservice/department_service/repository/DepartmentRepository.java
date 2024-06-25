package com.microservice.department_service.repository;

import com.microservice.department_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private final List<Department> departments;

    public DepartmentRepository(List<Department> departments) {
        this.departments = new ArrayList<>();
        addDepartment(new Department(1L, "IT"));
        addDepartment(new Department(2L, "CSE"));
    }

    public List<Department> findAll() {
        return departments;
    }

    public Department findById(Long id) {
        return departments.stream().filter(department -> department.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }
}
