package com.SpringProject.Task.Management.Application.ServiceImplementation;

import com.SpringProject.Task.Management.Application.DTOs.UsersDTOs;
import com.SpringProject.Task.Management.Application.Entities.Users;
import com.SpringProject.Task.Management.Application.Exceptions.UserNotFound;
import com.SpringProject.Task.Management.Application.Repositories.UsersRepo;
import com.SpringProject.Task.Management.Application.Service.UserService;
import jakarta.servlet.http.HttpServlet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements UserService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UsersRepo user_repo;

    public UsersDTOs saveUserData(UsersDTOs userdto){
        Users user=modelMapper.map(userdto,Users.class);
        user_repo.save(user);

        UsersDTOs userdto_data=modelMapper.map(user,UsersDTOs.class);
        return userdto_data;
    }

    public UsersDTOs getUserData(long id) {
        Users user= user_repo.findById(id).orElseThrow(
                ()->new UserNotFound("User Not there")
        );

       return modelMapper.map(user,UsersDTOs.class);
    }

    public void delUserData(long id) {
        Users user= user_repo.findById(id).orElseThrow(
                ()->new UserNotFound("User Not there")
        );
        user_repo.deleteById(id);
    }
}
