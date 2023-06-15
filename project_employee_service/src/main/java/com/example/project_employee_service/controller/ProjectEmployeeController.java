package com.example.project_employee_service.controller;

import com.example.project_employee_service.model.request.ProjectEmployeeRequest;
import com.example.project_employee_service.service.ProjectEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project-employee")
//@CrossOrigin("*")
public class ProjectEmployeeController {

    @Autowired
    private ProjectEmployeeService service;

    @GetMapping
    public ResponseEntity getList() {
        return ResponseEntity.ok().body(service.getList());
    }

    @GetMapping("/project/{id}")
    public ResponseEntity findAllByProject(@PathVariable(name = "id") Long idProject) {
        return ResponseEntity.ok().body(service.getListByProject(idProject));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity findAllByEmployee(@PathVariable(name = "id") Long idProject) {
        return ResponseEntity.ok().body(service.getListByEmployee(idProject));
    }

    @DeleteMapping()
    public ResponseEntity delete(@RequestBody ProjectEmployeeRequest projectEmployeeRequest) {
        return ResponseEntity.ok().body(service.deleteProjectEmployee(projectEmployeeRequest.getIdEmployee(),
                projectEmployeeRequest.getIdProject()));
    }

    @PostMapping()
    public ResponseEntity addProjectEmployee(@RequestBody ProjectEmployeeRequest projectEmployeeRequest) {

        return ResponseEntity.ok().body(service.addProjectEmployee(projectEmployeeRequest.getIdProject(),
                projectEmployeeRequest.getIdEmployee()));
    }

}
