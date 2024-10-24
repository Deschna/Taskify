package org.example.taskify.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.taskify.dto.mapper.ProjectMapper;
import org.example.taskify.dto.req.ProjectReqDto;
import org.example.taskify.dto.resp.ProjectRespDto;
import org.example.taskify.model.Project;
import org.example.taskify.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/initiate")
    ProjectRespDto initiateProject(@RequestBody ProjectReqDto projectReqDto) {
        Project project = ProjectMapper.INSTANCE.reqDtoToModel(projectReqDto);
        projectService.initiateProject(project);
        return ProjectMapper.INSTANCE.modelToRespDto(project);
    }

    @GetMapping("/{id}")
    ProjectRespDto getProjectById(@PathVariable Long id) {
        return ProjectMapper.INSTANCE.modelToRespDto(projectService.getProjectById(id));
    }

    @GetMapping("/all")
    public List<ProjectRespDto> getAllProjects() {
        return projectService.getAllProjects().stream().map(ProjectMapper.INSTANCE::modelToRespDto).toList();
    }
}
