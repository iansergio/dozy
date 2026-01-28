package com.backend.service;

import com.backend.domain.task.Task;
import com.backend.dto.TaskRequestDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    Task save(TaskRequestDTO request);
    List<Task> findAll();
    Optional<Task> findById(UUID id);
    Task delete(UUID id);
    Task update(UUID id, TaskRequestDTO request);
}
