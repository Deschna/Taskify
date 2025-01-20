package org.example.taskify.service;

import java.util.List;
import org.example.taskify.dto.request.ProjectRequestDto;
import org.example.taskify.dto.response.ProjectResponseDto;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    ProjectResponseDto initiateProject(ProjectRequestDto projectRequestDto);

    ProjectResponseDto getProjectById(Long id);

    List<ProjectResponseDto> getAllProjects(Pageable pageable);

    ProjectResponseDto updateProject(Long id, ProjectRequestDto projectRequestDto);

    void deleteProject(Long id);
}
