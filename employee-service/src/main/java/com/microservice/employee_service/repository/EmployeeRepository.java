package com.microservice.employee_service.repository;

import com.microservice.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = new ArrayList<>();
        addEmployee(new Employee(1L, "Nitin", 1L));
        addEmployee(new Employee(2L, "Nitin1", 1L));
        addEmployee(new Employee(3L, "Nitin2", 2L));
        addEmployee(new Employee(4L, "Nitin3", 2L));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream().filter(employee -> employee.getDeptId().equals(departmentId)).toList();
    }
}
