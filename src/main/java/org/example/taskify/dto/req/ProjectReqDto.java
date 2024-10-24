package org.example.taskify.dto.req;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ProjectReqDto {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
