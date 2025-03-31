package org.example.taskify.service;

import org.example.taskify.dto.request.ProjectRequestDto;
import org.example.taskify.dto.response.ProjectResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    ProjectResponseDto initiateProject(ProjectRequestDto projectRequestDto);

    ProjectResponseDto getProjectById(Long id);

    Page<ProjectResponseDto> getAllProjects(Pageable pageable);

    ProjectResponseDto updateProject(Long id, ProjectRequestDto projectRequestDto);

    void deleteProject(Long id);
}
