package com.example.project_employee_service.repository;

import com.example.project_employee_service.entity.ProjectEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Long> {
}
