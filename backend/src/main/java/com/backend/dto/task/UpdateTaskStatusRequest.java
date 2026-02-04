package com.backend.dto.task;

import com.backend.entity.task.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskStatusRequest {

    @NotNull(message = "Status is required")
    private Status status;

}
