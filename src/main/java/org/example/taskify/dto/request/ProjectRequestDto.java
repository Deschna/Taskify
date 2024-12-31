package org.example.taskify.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ProjectRequestDto {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
