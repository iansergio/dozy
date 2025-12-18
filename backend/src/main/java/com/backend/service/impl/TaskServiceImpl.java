package com.backend.service.impl;

import com.backend.dto.TaskRequest;
import com.backend.dto.TaskResponse;
import com.backend.entity.Task;
import com.backend.enums.Priority;
import com.backend.enums.Status;
import com.backend.repository.TaskRepository;
import com.backend.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskResponse save(TaskRequest request) {
        Task task = new Task(request);

        if (request.priority() == null) {
            task.setPriority(Priority.HIGH);
        }

        if (request.status() == null) {
            task.setStatus(Status.PENDING);
        }

        repository.save(task);
        return new TaskResponse(task);
    }
}
