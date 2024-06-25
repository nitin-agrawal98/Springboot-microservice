package com.microservice.employee_service.controller;

import com.microservice.employee_service.model.Employee;
import com.microservice.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Employee> getEmployees() {
        logger.info("Get all employees");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        logger.info("Get employee with id: {}", id);
        return repository.findById(id);
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.info("Added a new employee {}", employee);
        return repository.addEmployee(employee);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long departmentId) {
        logger.info("Get employees for department with id {}", departmentId);
        return repository.findByDepartment(departmentId);
    }
}
