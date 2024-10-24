package org.example.taskify.service;

import java.util.List;
import org.example.taskify.model.Project;

public interface ProjectService {
    void initiateProject(Project project);

    Project getProjectById(Long id);

    List<Project> getAllProjects();
}
