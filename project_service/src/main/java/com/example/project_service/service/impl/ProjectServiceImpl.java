package com.example.project_service.service.impl;

import com.example.project_service.entity.Project;
import com.example.project_service.repository.ProjectRepository;
import com.example.project_service.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    public Page<Project> getAll(String search, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return repository.findAllByMaContainsOrTenContains(search, search, pageable);
    }

    @Override
    public Project addProject(Project project) {
        return repository.save(project);
    }

    @Override
    public Project updateProject(Project project, Long id) {
        project.setId(id);
        return repository.save(project);
    }

    @Override
    public boolean deleteProject(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

//    @Bean
//    public void themTruoc() {
//        List<Project> list = new ArrayList<>();
//        list.add(new Project(1L, "PRO01", "Quản lý nhân viên", "10-02-2023", "10-04-2023"));
//        list.add(new Project(2L, "PRO02", "Quản lý nhân sự", "10-02-2023", "10-04-2023"));
//        list.add(new Project(3L, "PRO03", "Web bán hàng online", "10-02-2023", "10-04-2023"));
//        list.add(new Project(4L, "PRO04", "Ứng dụng bán hàng tại quầy", "10-02-2023", "10-04-2023"));
//        list.add(new Project(5L, "PRO05", "Quản lý sự kiện", null, "10-04-2023"));
//        list.add(new Project(10L, "PRO10", "Quản lý dự án", "10-02-2023", null));
//        list.add(new Project(11L, "PRO11", "Quản lý nhân viên", "10-02-2023", "10-04-2023"));
//        repository.saveAll(list);
//    }
}
