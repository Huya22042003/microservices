package com.example.project_employee_service.service.impl;

import com.example.project_employee_service.entity.ProjectEmployee;
import com.example.project_employee_service.model.response.EmployeeResponse;
import com.example.project_employee_service.model.response.ProjectEmployeeResponse;
import com.example.project_employee_service.model.response.ProjectResponse;
import com.example.project_employee_service.repository.ProjectEmployeeRepository;
import com.example.project_employee_service.service.ProjectEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectEmployeeServiceImpl implements ProjectEmployeeService {

    @Autowired
    private ProjectEmployeeRepository repository;

    @Autowired
    private WebClient.Builder webClient;

    private List<ProjectEmployee> list = new ArrayList<>();

    @Override
    public List<ProjectEmployeeResponse> getList() {
        list = repository.findAll();
        List<ProjectEmployeeResponse> employeeResponseList = new ArrayList<>();
        list.forEach((el) -> {
            employeeResponseList.add(new ProjectEmployeeResponse(el.getId(),
                    employeeEmployee(el.getEmployeeId()),
                    projectEmployee(el.getProjectId())));
        });
        return employeeResponseList;
    }

    @Override
    public List<ProjectEmployeeResponse> getListByProject(Long id) {
        list = repository.findAll();
        List<ProjectEmployeeResponse> employeeResponseList = new ArrayList<>();
        list.forEach((el) -> {
            if (el.getProjectId() == id) {
                employeeResponseList.add(new ProjectEmployeeResponse(el.getId(),
                        employeeEmployee(el.getEmployeeId()),
                        projectEmployee(el.getProjectId())));
            }
        });
        return employeeResponseList;
    }

    @Override
    public List<ProjectEmployeeResponse> getListByEmployee(Long id) {
        list = repository.findAll();
        List<ProjectEmployeeResponse> employeeResponseList = new ArrayList<>();
        list.forEach((el) -> {
            if (el.getEmployeeId() == id) {
                employeeResponseList.add(new ProjectEmployeeResponse(el.getId(),
                        employeeEmployee(el.getEmployeeId()),
                        projectEmployee(el.getProjectId())));
            }
        });
        return employeeResponseList;
    }

    @Override
    public boolean addProjectEmployee(Long idProject, Long idEmployee) {
        ProjectEmployee projectEmployee = new ProjectEmployee();
        projectEmployee.setEmployeeId(idEmployee);
        projectEmployee.setProjectId(idProject);
        repository.save(projectEmployee);
        return true;
    }

    @Override
    public boolean deleteProjectEmployee(Long idEmployee, Long idProject) {
        list = repository.findAll();
        Long id = -1L;
        for (ProjectEmployee el: list) {
            if (el.getEmployeeId() == idEmployee && el.getProjectId() == idProject) {
                id = el.getId();
            }
        }
        if (id != -1L) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public ProjectResponse projectEmployee(Long id) {
        return webClient.build().get()
                .uri("http://project-service/api/project/"+id)
                .retrieve()
                .bodyToMono(ProjectResponse.class)
                .block();
    }

    public EmployeeResponse employeeEmployee(Long id) {
        return webClient.build().get()
                .uri("http://employee-service/api/employee/"+id)
                .retrieve()
                .bodyToMono(EmployeeResponse.class)
                .block();
    }

}
