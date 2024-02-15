package com.example.contacttodomail.Controllers;

import com.example.contacttodomail.DTO.Tasks;
import com.example.contacttodomail.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Tasks")
public class TaskController {

    @Autowired
    private TaskService task_service;

    @GetMapping("/GetAllTasks")
    @ResponseBody
    public ResponseEntity<List<Tasks>> GetAllTasks(){
        return new ResponseEntity<>(task_service.GetAllTask(), HttpStatus.OK);
    }

    @PostMapping("/NewTask")
    public Tasks PostUser(@RequestBody Tasks task) throws Exception {
        return task_service.AddNewTask(task);
    }

    @PutMapping("/UpdateTask")
    public Tasks PutUser(@RequestBody Tasks update) {
        return task_service.UpdateTask(update);
    }

    @DeleteMapping("/DeleteTask/{id}")
    public String DeleteProfile(@PathVariable("id") String id) {
        return task_service.DeleteTask(id);
    }
}
