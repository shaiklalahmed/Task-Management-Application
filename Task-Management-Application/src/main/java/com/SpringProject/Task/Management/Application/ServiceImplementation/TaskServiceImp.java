package com.SpringProject.Task.Management.Application.ServiceImplementation;

import com.SpringProject.Task.Management.Application.DTOs.TasksDTOs;
import com.SpringProject.Task.Management.Application.Entities.Tasks;
import com.SpringProject.Task.Management.Application.Entities.Users;
import com.SpringProject.Task.Management.Application.Exceptions.TaskNotFound;
import com.SpringProject.Task.Management.Application.Exceptions.UserNotFound;
import com.SpringProject.Task.Management.Application.Repositories.TasksRepo;
import com.SpringProject.Task.Management.Application.Repositories.UsersRepo;
import com.SpringProject.Task.Management.Application.Service.TasksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TasksService {

      @Autowired
      ModelMapper modelMapper;

      @Autowired
      TasksRepo tasksRepo;

      @Autowired
      UsersRepo usersRepo;

    public TasksDTOs saveTaskData(long id, TasksDTOs taskDt) {
        Users user=usersRepo.findById(id).orElseThrow(
                () -> new UserNotFound("User Id Not Found")
        );
        Tasks tasks=modelMapper.map(taskDt,Tasks.class);
        tasks.setUsers(user);
        Tasks t1=tasksRepo.save(tasks);
       return modelMapper.map(t1,TasksDTOs.class);
    }


    public List<TasksDTOs> getAllTaskData(long users_id) {
        Users user=usersRepo.findById(users_id).orElseThrow(
                () -> new UserNotFound("User Id Not Found")
        );
       List<Tasks> tasks= tasksRepo.findAllByUsersId(users_id);

        return tasks.stream().map(
                task -> modelMapper.map(task,TasksDTOs.class)
        ).collect(Collectors.toList());
    }

    public void delTaskData(long userId, long taskId) {
         Users user= usersRepo.findById(userId).orElseThrow(
                 ()->new UserNotFound("User Not there")
         );

         Tasks task=tasksRepo.findById(taskId).orElseThrow(
                 ()->new TaskNotFound("User Not there")
         );

         tasksRepo.deleteById(taskId);
    }
}
