package org.example.taskify.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.taskify.exception.EntityNotFoundException;
import org.example.taskify.model.Project;
import org.example.taskify.repository.ProjectRepository;
import org.example.taskify.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public void initiateProject(Project project) {
        project.setStatus(Project.Status.INITIATED);
        projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        if (projectRepository.existsById(id)) {
            return projectRepository.getReferenceById(id);
        }
        throw new EntityNotFoundException("Project with id " + id + " not found");
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
