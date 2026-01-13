package com.vkRestapi.RestApis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vkRestapi.RestApis.Employee;
import com.vkRestapi.RestApis.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // READ BY ID
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee newEmployee) {
        Employee emp = repository.findById(id).orElse(null);

        if (emp != null) {
            emp.setFirstName(newEmployee.getFirstName());
            emp.setLastName(newEmployee.getLastName());
            emp.setEmail(newEmployee.getEmail());
            return repository.save(emp);
        }
        return null;
    }

    // DELETE
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
