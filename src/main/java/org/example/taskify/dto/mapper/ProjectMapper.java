package org.example.taskify.dto.mapper;

import org.example.taskify.config.MapperConfig;
import org.example.taskify.dto.request.ProjectRequestDto;
import org.example.taskify.dto.response.ProjectResponseDto;
import org.example.taskify.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface ProjectMapper {
    @Mapping(source = "status", target = "status", qualifiedByName = "statusToString")
    ProjectResponseDto modelToResponseDto(Project project);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Project requestDtoToModel(ProjectRequestDto projectRequestDto);

    @Named("statusToString")
    default String statusToString(Project.Status status) {
        return status != null ? status.name() : null;
    }
}
