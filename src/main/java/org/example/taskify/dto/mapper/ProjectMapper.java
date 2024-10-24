package org.example.taskify.dto.mapper;

import org.example.taskify.dto.req.ProjectReqDto;
import org.example.taskify.dto.resp.ProjectRespDto;
import org.example.taskify.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectRespDto modelToRespDto(Project project);

    Project reqDtoToModel(ProjectReqDto projectReqDto);
}
