package com.saasify.taskapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private Map<String, List<String>> tenantTasks = new HashMap<>();

    @GetMapping
    public List<String> getTasks(
            @RequestHeader(value = "tenant-id", defaultValue = "default") String tenant) {

        return tenantTasks.getOrDefault(tenant, new ArrayList<>());
    }

    @PostMapping
    public String addTask(
            @RequestHeader(value = "tenant-id", defaultValue = "default") String tenant,
            @RequestBody String task) {

        tenantTasks.putIfAbsent(tenant, new ArrayList<>());
        tenantTasks.get(tenant).add(task);

        return "Task added for tenant: " + tenant;
    }
}
