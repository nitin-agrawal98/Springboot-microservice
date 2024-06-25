package com.microservice.department_service.controller;

import com.microservice.department_service.model.Department;
import com.microservice.department_service.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Department> getDepartments() {
        LOGGER.info("Get all departments");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable long id) {
        LOGGER.info("Get department with id: {}", id);
        return service.findById(id);
    }

    @PostMapping("")
    public Department addDepartment(@RequestBody Department department) {
        LOGGER.info("Added a new department {}", department);
        return service.addDepartment(department);
    }

    @GetMapping("/{id}/with-employees")
    public Department getDepartmentWithEmployees(@PathVariable long id) {
        LOGGER.info("Get department with id: {} with all employees", id);
        return service.getDepartmentWithEmployees(id);
    }
}
