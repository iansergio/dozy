package com.backend.dto;

import com.backend.entity.Task;
import com.backend.enums.Priority;
import com.backend.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponse(
        UUID id,
        String title,
        String description,
        Priority priority,
        Status status,
        LocalDateTime dueDate

) {
    public TaskResponse(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getPriority(), task.getStatus(), task.getDueDate());
    }
}
