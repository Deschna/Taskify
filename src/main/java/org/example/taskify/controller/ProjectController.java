package org.example.taskify.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.taskify.dto.request.ProjectRequestDto;
import org.example.taskify.dto.response.ProjectResponseDto;
import org.example.taskify.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/initiate")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto initiateProject(
            @RequestBody @Valid ProjectRequestDto projectRequestDto
    ) {
        return projectService.initiateProject(projectRequestDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponseDto getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponseDto updateProjectById(
            @PathVariable Long id,
            @RequestBody @Valid ProjectRequestDto projectRequestDto
    ) {
        return projectService.updateProject(id, projectRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjectById(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
