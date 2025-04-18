package com.SpringProject.Task.Management.Application.Controllers;

import com.SpringProject.Task.Management.Application.DTOs.TasksDTOs;
import com.SpringProject.Task.Management.Application.ServiceImplementation.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

        @Autowired
       TaskServiceImp tsi;

    @PostMapping("/{userId}/tasks")
    public ResponseEntity<TasksDTOs> saveData(@PathVariable(name="userId") long id,  @RequestBody TasksDTOs taskdto) {
       return new ResponseEntity<>(tsi.saveTaskData(id, taskdto),HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<TasksDTOs>> getData(@PathVariable (name="userId") long user_id){
         return new ResponseEntity<>(tsi.getAllTaskData(user_id),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{taskId}/tasks")
    public void delData(@PathVariable (name="userID") long user_id,@PathVariable (name="taskId") long task_id){
        tsi.delTaskData(user_id,task_id);
    }


}
