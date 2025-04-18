package com.SpringProject.Task.Management.Application.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class TaskNotFound extends RuntimeException{

    public TaskNotFound(String message){
        super(message);
    }
}
