package com.SpringProject.Task.Management.Application.Service;

import com.SpringProject.Task.Management.Application.DTOs.TasksDTOs;
import com.SpringProject.Task.Management.Application.Entities.Tasks;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TasksService {
    public TasksDTOs saveTaskData(long id, TasksDTOs taskDto_data);

    public List<TasksDTOs> getAllTaskData(long user_id);
}
