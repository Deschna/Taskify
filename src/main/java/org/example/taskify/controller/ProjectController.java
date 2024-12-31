package org.example.taskify.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.taskify.dto.request.ProjectRequestDto;
import org.example.taskify.dto.response.ProjectResponseDto;
import org.example.taskify.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/initiate")
    ResponseEntity<ProjectResponseDto> initiateProject(
            @RequestBody ProjectRequestDto projectRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.initiateProject(projectRequestDto));
    }

    @GetMapping("/{id}")
    ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        List<ProjectResponseDto> projects = projectService.getAllProjects();
        return projects.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    ResponseEntity<ProjectResponseDto> updateProjectById(
            @PathVariable Long id,
            @RequestBody ProjectRequestDto projectRequestDto
    ) {
        return ResponseEntity.ok(projectService.updateProject(id, projectRequestDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProjectById(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
