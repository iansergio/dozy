package com.backend.service;

import com.backend.domain.task.Task;
import com.backend.dto.GetTaskRequest;
import com.backend.dto.UpdateTaskInfosRequest;
import com.backend.dto.UpdateTaskStatusRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    Task save(GetTaskRequest request);
    List<Task> findAll();
    Optional<Task> findById(UUID id);
    Task delete(UUID id);
    Task update(UUID id, GetTaskRequest request);
    Task updateStatus(UUID id, UpdateTaskStatusRequest request);
    Task updateTaskInfo(UUID id, UpdateTaskInfosRequest request);
}
