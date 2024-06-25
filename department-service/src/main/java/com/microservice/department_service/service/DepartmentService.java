package com.microservice.department_service.service;

import com.microservice.department_service.client.EmployeeClient;
import com.microservice.department_service.model.Department;
import com.microservice.department_service.model.Employee;
import com.microservice.department_service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;
    private final EmployeeClient employeeClient;

    @Autowired
    public DepartmentService(DepartmentRepository repository, EmployeeClient client) {
        this.repository = repository;
        this.employeeClient = client;
    }
    public List<Department> findAll() {
        return repository.findAll();
    }

    public Department findById(Long id) {
        return repository.findById(id);
    }

    public Department addDepartment(Department department) {
        return repository.addDepartment(department);
    }

    public Department getDepartmentWithEmployees(Long id) {
        List<Employee> employees = employeeClient.getEmployeesByDepartment(id);
        Department department = findById(id);
        department.setEmployees(employees);
        return department;
    }
}
