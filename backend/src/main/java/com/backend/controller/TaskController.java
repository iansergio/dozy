package com.backend.controller;

import com.backend.dto.TaskRequest;
import com.backend.dto.TaskResponse;
import com.backend.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> save(@Valid @RequestBody TaskRequest request) {
        TaskResponse response = service.save(request);
        URI location = URI.create("/api/tasks/" + response.id());

        return ResponseEntity.created(location).body(response);
    }
}
