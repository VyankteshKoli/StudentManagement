package com.vkRestapi.RestApis.repository;

import com.vkRestapi.RestApis.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
