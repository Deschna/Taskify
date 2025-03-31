package org.example.taskify.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.taskify.dto.mapper.ProjectMapper;
import org.example.taskify.dto.request.ProjectRequestDto;
import org.example.taskify.dto.response.ProjectResponseDto;
import org.example.taskify.exception.EntityNotFoundException;
import org.example.taskify.model.Project;
import org.example.taskify.repository.ProjectRepository;
import org.example.taskify.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponseDto initiateProject(ProjectRequestDto projectRequestDto) {
        Project project = projectMapper.requestDtoToModel(projectRequestDto);
        project.setStatus(Project.Status.INITIATED);
        return projectMapper.modelToResponseDto(projectRepository.save(project));
    }

    @Override
    public ProjectResponseDto getProjectById(Long id) {
        return projectMapper.modelToResponseDto(projectRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Project with id " + id + " not found")));
    }

    @Override
    public Page<ProjectResponseDto> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable).map(projectMapper::modelToResponseDto);
    }

    @Override
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto projectRequestDto) {
        Project project = projectRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Project with id " + id + " not found"));
        projectMapper.updateModelFromRequestDto(projectRequestDto, project);
        return projectMapper.modelToResponseDto(projectRepository.save(project));
    }

    @Override
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project with id " + id + " not found");
        }
        projectRepository.deleteById(id);
    }
}
