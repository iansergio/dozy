package com.backend.dto;

import com.backend.domain.task.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskStatusRequest {

    @NotNull(message = "Status cannot be null")
    private TaskStatus status;

}
