package com.backend.service;

import com.backend.dto.task.SaveTaskRequest;
import com.backend.dto.task.TaskResponse;
import com.backend.dto.task.UpdateTaskInfosRequest;
import com.backend.dto.task.UpdateTaskStatusRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    TaskResponse save(SaveTaskRequest request);
    List<TaskResponse> findAll();
    Optional<TaskResponse> findById(UUID id);
    void delete(UUID id);
    TaskResponse updateTaskInfos(UUID id, UpdateTaskInfosRequest request);
    TaskResponse updateStatus(UUID id, UpdateTaskStatusRequest request);
}
