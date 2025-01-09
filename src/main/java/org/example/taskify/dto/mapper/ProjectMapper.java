package org.example.taskify.dto.mapper;

import org.example.taskify.config.MapperConfig;
import org.example.taskify.dto.request.ProjectRequestDto;
import org.example.taskify.dto.response.ProjectResponseDto;
import org.example.taskify.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface ProjectMapper {
    ProjectResponseDto modelToResponseDto(Project project);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Project requestDtoToModel(ProjectRequestDto projectRequestDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    void updateModelFromRequestDto(ProjectRequestDto projectRequestDto,
                                   @MappingTarget Project project);
}
