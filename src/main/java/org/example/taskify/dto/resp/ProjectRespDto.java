package org.example.taskify.dto.resp;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ProjectRespDto {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}
