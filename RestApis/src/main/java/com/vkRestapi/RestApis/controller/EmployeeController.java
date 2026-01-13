package com.vkRestapi.RestApis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vkRestapi.RestApis.Employee;
import com.vkRestapi.RestApis.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    // READ ALL
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted with id " + id;
    }
}
