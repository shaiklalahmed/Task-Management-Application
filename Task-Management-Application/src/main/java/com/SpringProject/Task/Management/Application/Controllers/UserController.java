package com.SpringProject.Task.Management.Application.Controllers;

import com.SpringProject.Task.Management.Application.DTOs.UsersDTOs;
import com.SpringProject.Task.Management.Application.ServiceImplementation.UsersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

             @Autowired
             UsersServiceImp service;

          @PostMapping("/createData")
         public ResponseEntity<UsersDTOs> saveData(@RequestBody UsersDTOs userdto){
              return new ResponseEntity<>(service.saveUserData(userdto), HttpStatus.CREATED);
         }

         @GetMapping("/{userID}")
         public ResponseEntity<UsersDTOs> getData(@PathVariable (name="userId") long id){
             return new ResponseEntity<>(service.getUserData(id), HttpStatus.CREATED);
         }

    @DeleteMapping("/{userID}")
    public void delData(@PathVariable (name="userId") long id){
        service.delUserData(id);
    }


}
