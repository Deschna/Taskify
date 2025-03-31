package org.example.taskify.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.taskify.dto.request.ProjectRequestDto;
import org.example.taskify.dto.response.ProjectResponseDto;
import org.example.taskify.service.ProjectService;
import org.example.taskify.util.SortUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
@Tag(name = "Project Controller", description = "Operations related to project management")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(
            summary = "Initiate a new project",
            description = "Creates a new project based on the provided details"
    )
    @PostMapping("/initiate")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto initiateProject(
            @RequestBody @Valid ProjectRequestDto projectRequestDto
    ) {
        return projectService.initiateProject(projectRequestDto);
    }

    @Operation(
            summary = "Get project by ID",
            description = "Fetches the details of a specific project using its ID"
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponseDto getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @Operation(
            summary = "Get all projects",
            description = "Retrieves a paginated list with sorting of all projects"
    )
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Page<ProjectResponseDto> getAllProjects(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @Parameter(description = "Sorting parameters in the format "
                    + "'name:direction,name:direction,...'. Direction can be 'asc' or 'desc'.")
            @RequestParam(required = false) String[] sortParams
    ) {
        Sort sort = SortUtils.parseSort(sortParams, "name");
        return projectService.getAllProjects(PageRequest.of(pageNumber, pageSize, sort));
    }

    @Operation(
            summary = "Update project by ID",
            description = "Updates the details of a specific project using its ID"
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponseDto updateProjectById(
            @PathVariable Long id,
            @RequestBody @Valid ProjectRequestDto projectRequestDto
    ) {
        return projectService.updateProject(id, projectRequestDto);
    }

    @Operation(
            summary = "Delete project by ID",
            description = "Deletes a specific project using its ID"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjectById(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
