package com.example.employee_service.service;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.model.response.PageableObject;

public interface EmployeeService {
    PageableObject<Employee> getList(String search, int total);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    boolean deleteEmployee(Long id);
    Employee findById(Long id);
}
