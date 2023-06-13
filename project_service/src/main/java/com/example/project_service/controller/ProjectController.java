package com.example.project_service.controller;

import com.example.project_service.entity.Project;
import com.example.project_service.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public ResponseEntity getAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "search", defaultValue = "") String search
                                          ) {
        return ResponseEntity.ok().body(service.getAll(search, page));
    }

    @PostMapping
    public ResponseEntity addProject(@RequestBody Project project) {
        return ResponseEntity.ok().body(service.addProject(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProject(@RequestBody Project project, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.updateProject(project, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProject(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.deleteProject(id));
    }

}
