package com.backend.service.impl;

import com.backend.domain.task.Task;
import com.backend.domain.task.TaskStatus;
import com.backend.domain.user.User;
import com.backend.dto.GetTaskRequest;
import com.backend.dto.UpdateTaskInfosRequest;
import com.backend.dto.UpdateTaskStatusRequest;
import com.backend.repository.TaskRepository;
import com.backend.repository.UserRepository;
import com.backend.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task save(GetTaskRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User associated with task not found"));

        if (request.getStatus() == null) {
            request.setStatus(TaskStatus.PENDING);
        }

        Task task = new Task(
                request.getTitle(),
                request.getDescription(),
                request.getPriority(),
                request.getStatus(),
                request.getDueDate(),
                user
        );

        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(UUID id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task delete(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found with id: " + id));
        taskRepository.delete(task);
        return task;
    }

    @Override
    public Task update(UUID id, GetTaskRequest request) {
        Task updatedTask = taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        updatedTask.setTitle(request.getTitle());
        updatedTask.setDescription(request.getDescription());
        updatedTask.setPriority(request.getPriority());
        updatedTask.setStatus(request.getStatus());
        updatedTask.setDueDate(request.getDueDate());

        return taskRepository.save(updatedTask);
    }

    @Override
    public Task updateStatus(UUID id, UpdateTaskStatusRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        task.setStatus(request.getStatus());
        return taskRepository.save(task);
    }

    @Override
    public Task updateTaskInfo(UUID id, UpdateTaskInfosRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        if (request.getTitle() != null) {
            task.setTitle(request.getTitle());
        }

        if(request.getDescription() != null) {
            task.setDescription(request.getDescription());
        }

        if(request.getPriority() != null) {
            task.setPriority(request.getPriority());
        }

        if(request.getDueDate() != null) {
            task.setDueDate(request.getDueDate());
        }
        return taskRepository.save(task);
    }
}
