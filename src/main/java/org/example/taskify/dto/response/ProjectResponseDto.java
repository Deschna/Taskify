package org.example.taskify.dto.response;

import java.time.LocalDate;
import lombok.Data;
import org.example.taskify.model.Project;

@Data
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Project.Status status;
}
