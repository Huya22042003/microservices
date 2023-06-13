package com.example.employee_service.repository;

import com.example.employee_service.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page findByMaContainsOrTenContainsOrderById(String ma, String ten, Pageable pageable);
}
