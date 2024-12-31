package org.example.taskify.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
