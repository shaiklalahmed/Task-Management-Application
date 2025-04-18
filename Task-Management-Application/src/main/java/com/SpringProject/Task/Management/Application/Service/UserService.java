package com.SpringProject.Task.Management.Application.Service;

import com.SpringProject.Task.Management.Application.DTOs.UsersDTOs;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public UsersDTOs saveUserData(UsersDTOs userdto);
}
