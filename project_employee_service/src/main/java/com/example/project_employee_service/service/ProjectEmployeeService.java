package com.example.project_employee_service.service;

import com.example.project_employee_service.model.response.ProjectEmployeeResponse;

import java.util.List;

public interface ProjectEmployeeService {
    List<ProjectEmployeeResponse> getList();
    List<ProjectEmployeeResponse> getListByProject(Long id);
    List<ProjectEmployeeResponse> getListByEmployee(Long id);
    boolean addProjectEmployee(Long idProject, Long idEmployee);
    boolean deleteProjectEmployee(Long idEmployee, Long idProject);
}
