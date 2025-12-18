package com.backend.dto;

import com.backend.enums.Priority;
import com.backend.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TaskRequest(
        @NotBlank
        @Size(min = 3, message = "O título deve ter pelo menos 3 caracteres")
        String title,

        @NotBlank
        @Size(max = 200, message = "A descrição deve ter no máximo 200 caracteres")
        String description,

        Priority priority,
        Status status,

        @NotNull(message = "Data e hora são obrigatórias.")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime dueDate
) {
}
