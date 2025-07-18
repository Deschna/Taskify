package org.example.taskify.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;
import org.example.taskify.lib.annotation.DateOrder;

@Data
@DateOrder(firstDateField = "startDate", secondDateField = "endDate",
        message = "Start date must be before end date")
public class ProjectRequestDto {
    @NotBlank(message = "Project name cannot be empty")
    @Size(max = 255, message = "Project name must not exceed 255 characters")
    private String name;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;

    @FutureOrPresent(message = "Start date must be today or in the future")
    private LocalDate startDate;

    @Future(message = "End date must be in the future")
    private LocalDate endDate;
}
