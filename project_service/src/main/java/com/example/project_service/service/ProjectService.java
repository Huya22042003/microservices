package com.example.project_service.service;

import com.example.project_service.entity.Project;
import org.springframework.data.domain.Page;

public interface ProjectService {
    Page<Project> getAll(String search, int page);
    Project addProject(Project project);
    Project updateProject(Project project, Long id);
    boolean deleteProject(Long id);
}
