package com.example.project_service.service;

import com.example.project_service.entity.Project;
import com.example.project_service.model.response.PageableObject;

public interface ProjectService {
    PageableObject<Project> getAll(String search, int page);
    Project addProject(Project project);
    Project updateProject(Project project, Long id);
    boolean deleteProject(Long id);
    Project findById(Long id);
}
